package services

import akka.actor.ActorSystem
import com.typesafe.scalalogging.LazyLogging

import java.time.LocalDate.now
import java.time.{LocalDate, LocalDateTime, LocalTime}
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{DurationInt, DurationLong}

class EmpireArmsChecker(baseUrl: String)(implicit system: ActorSystem) extends LazyLogging {
  // Use baseUrl parameter instead of hardcoded URL in generateUrl method
  def generateUrl(): String = {
    baseUrl + getDateSuffix + ".htm"
  }

  def run(): Future[Boolean] = {
    val url = generateUrl()
    val telegramService = new TelegramServiceImpl
    val webpageCreated = isValidUrl(url)
    if (webpageCreated) {
      println("Webpage created successfully")
      telegramService.sendMessage(url)
      Future.successful(true)
    } else {
      println(s"$url")
      retryUntilSuccess(() => run())
    }

  }

  def retryUntilSuccess(runFunction: () => Future[Boolean]): Future[Boolean] = {
    val minDelayMillis = 10000 // Minimum delay in milliseconds
    val maxDelayMillis = 90000 // Maximum delay in milliseconds

    def retry(): Future[Boolean] = {
      val randomDelay = Random.nextInt(maxDelayMillis - minDelayMillis) + minDelayMillis
      println(s"Retrying in $randomDelay milliseconds")
      akka.pattern.after(randomDelay.millis, system.scheduler) {
        println("Inside delay")
        runFunction().flatMap { result =>
          if (result) {
            Future.successful(result)
          } else {
            retry()
          }
        }
      }
    }

    retry()
  }


  def isValidUrl(url: String): Boolean = {
    try {
      val response = requests.get(url, readTimeout = 1000, connectTimeout = 10000, check = false)
      val status = response.statusCode
      println(s"URL: $url, Status code: $status")
      status == 200
    } catch {
      case _: requests.TimeoutException =>
        println(s"URL: $url, Request timed out")
        false
    }
  }

  def waitForNextDayAndRetry (runFunction: () => Future[Boolean]): Future[Boolean] = {
    val now = LocalDateTime.now()
    val nextDayStart = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT)
    val delayMillis = now.until(nextDayStart, ChronoUnit.MILLIS)

    println(s"Sleeping for $delayMillis milliseconds until the next day")

    akka.pattern.after(delayMillis.millis, system.scheduler)(retryUntilSuccess(runFunction))
  }


  def initiateRetry(): Unit = {
    val resultFuture = waitForNextDayAndRetry(() => run())

    resultFuture.onComplete {
      case Success(result) =>
        println(s"Success! Result: $result")
      case Failure(error) =>
        println(s"Error: ${error.getMessage}")
    }
  }

  def getDateSuffix(): String = {
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("MMddyy")
    today.format(formatter)
  }
}
