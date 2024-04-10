import akka.actor.ActorSystem
import com.typesafe.scalalogging.LazyLogging
import services.EmpireArmsChecker
//import services.EmpireArmsChecker
//import services.{EmpireArmsServiceImpl, TelegramServiceImpl}
//
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.time.temporal.ChronoUnit
//import scala.concurrent.Future
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.util.{Failure, Random, Success}
//import java.time.{LocalDate, LocalDateTime, LocalTime, ZoneOffset}

object Main2 extends App with LazyLogging {

  // Define the fixed base URL
  val baseUrl = "https://www.empirearms.com/"

  // Create an implicit ActorSystem
  implicit val system: ActorSystem = ActorSystem("EmpireArmsCheckerSystem")

  // Create an instance of EmpireArmsChecker with the fixed base URL
  val empireArmsChecker = new EmpireArmsChecker(baseUrl)

  // Run the EmpireArmsChecker
  empireArmsChecker.run()

//  def run(): Future[Boolean] = {
//    val baseUrl = "https://www.empirearms.com/"
//    val url = baseUrl + getDateSuffix + ".htm"
//    val empireArmsService = new EmpireArmsServiceImpl
//    val telegramService = new TelegramServiceImpl
//    val isValidUrl = empireArmsService.isValidUrl(url)
//    if (isValidUrl) {
//      telegramService.sendMessage(url)
//      Future.successful(true)
//    } else {
//      println("I am sad")
//      retryUntilSuccess(() => run())
//    }
//  }
//
//  def retryUntilSuccess(runFunction: () => Future[Boolean]): Future[Boolean] = {
//    val minDelayMillis = 100000 // Minimum delay in milliseconds
//    val maxDelayMillis = 500000 // Maximum delay in milliseconds
//    var attempts = 0 // Counter for tracking attempts
//
//    def retry(): Future[Boolean] = {
//      attempts += 1 // Increment the attempt counter
//      runFunction().flatMap { result =>
//        if (result) {
//          Future.successful(result)
//        } else {
//          val randomDelay = Random.nextInt(maxDelayMillis - minDelayMillis) + minDelayMillis
//          Thread.sleep(randomDelay)
//          retry()
//        }
//      }
//    }
//
//    retry().map { result =>
//      println(s"Total attempts made: $attempts")
//      result
//    }
//  }
//
//  def waitForNextDayAndRetry(runFunction: () => Future[Boolean]): Future[Boolean] = {
//    val now = LocalDateTime.now()
//    val nextDayStart = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT)
//    val delayMillis = now.until(nextDayStart, ChronoUnit.MILLIS)
//
//    println(s"Sleeping for $delayMillis milliseconds until the next day")
//
//    Thread.sleep(delayMillis)
//
//    retryUntilSuccess(runFunction)
//  }
//
//  val resultFuture = waitForNextDayAndRetry(() => run())
//
//  resultFuture.onComplete {
//    case Success(result) =>
//      println(s"Success! Result: $result")
//    case Failure(error) =>
//      println(s"Error: ${error.getMessage}")
//  }
//
//
//
//
//
//  def getDateSuffix(): String = {
//    val today = LocalDate.now()
//    val formatter = DateTimeFormatter.ofPattern("MMddyy")
//    today.format(formatter)
//  }
}



/**
 * check empire arms link
 * send telegram with link
 *
 * every 2 min
 * then sleep until next calendar day
 *
 * create trait for empire arms service
 * def checkUrl (url: String) : Future [Boolean]
 * create imp for trait empire arms
 * create trait for telegram service
 * def sendMessage
 * create impl for trait telegram
 */










//import com.typesafe.scalalogging.LazyLogging
//import services.{EmpireArmsService, EmpireArmsServiceImpl, TelegramService, TelegramServiceImpl}
//
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import scala.concurrent.{ExecutionContext, Future}
//import scala.util.{Failure, Success}
//
//object Main2 extends LazyLogging { ///App with
//  logger.info("1")
//  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
//
//  def main(args: Array[String]): Unit = {
//    run()
//    logger.info("2")
//  }
//
//  def run(): Unit = {
//    val baseUrl = "https://www.empirearms.com/"
//    val url = baseUrl + getDateSuffix + ".htm"
//    logger.info("3")
//
//    val empireArmsService: EmpireArmsService = new EmpireArmsServiceImpl()
//    val telegramService: TelegramServiceImpl = new TelegramServiceImpl()
//
//    val isValidUrlFuture: Future[Boolean] = empireArmsService.isValidURL(url)
//    logger.info("4")
//    isValidUrlFuture.onComplete {
//      case Success(isValid) =>
//        if (isValid) {
//          val botToken = "6283092723:AAHPJn47wwxal3nVsy7o2OLTCxom7KxFB"
//          val chatId = "1001921543197"
//          val message = s"URL: $url"
//          telegramService.sendTelegramMessage(botToken, chatId, message).onComplete {
//            case Success(_) =>
//              println("Message sent successfully!")
//            case Failure(exception) =>
//              println(s"Failed to send message. An error occurred: ${exception.getMessage}")
//          }
//        } else {
//          println("Invalid URL. Telegram message not sent.")
//        }
//      case Failure(exception) =>
//        println(s"An error occurred while checking the URL: ${exception.getMessage}")
//    }
//  }
//
//  def getDateSuffix(): String = {
//    logger.info("5")
//    val yesterday = LocalDate.now().minusDays(1)
//    val formatter = DateTimeFormatter.ofPattern("MMddyy")
//    yesterday.format(formatter)
//  }
//}

//val botToken = "6283092723:AAHPJn47wwxal3nVsy7o2OLTCxom7KxFB"
//val chatId = "1001921543197"

//import com.typesafe.scalalogging.LazyLogging
//import services.{EmpireArmsService, EmpireArmsServiceImpl, TelegramService, TelegramServiceImpl}
//
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import scala.concurrent.{ExecutionContext, Future}
//import scala.util.{Failure, Success}
//
//object Main2 extends LazyLogging {
//  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
//
//  def main(args: Array[String]): Unit = {
//    run()
//  }
//
//  def run(): Unit = {
//    logger.info("1")
//    val baseUrl = "https://www.empirearms.com/"
//    val url = baseUrl + getDateSuffix + ".htm"
//    logger.info("2")
//
//    val empireArmsService: EmpireArmsService = new EmpireArmsServiceImpl()
//    val telegramService: TelegramService = new TelegramServiceImpl()
//
//    val isValidUrlFuture: Future[Boolean] = empireArmsService.isValidUrl(url)
//    logger.info("3")
//    isValidUrlFuture.onComplete {
//      case Success(isValid) =>
//        if (isValid) {
//          val botToken = "6283092723:AAHPJn47wwxal3nVsy7o2OLTCxom7KxFB"
//          val chatId = "1001921543197"
//          val message = s"URL: $url"
//          telegramService.sendTelegramMessage(botToken, chatId, message).onComplete {
//            case Success(_) =>
//              println("Message sent successfully!")
//            case Failure(exception) =>
//              println(s"Failed to send message. An error occurred: ${exception.getMessage}")
//          }
//        } else {
//          println("Invalid URL. Telegram message not sent.")
//        }
//      case Failure(exception) =>
//        println(s"An error occurred while checking the URL: ${exception.getMessage}")
//    }
//  }
//
//  def getDateSuffix(): String = {
//    val yesterday = LocalDate.now().minusDays(1)
//    val formatter = DateTimeFormatter.ofPattern("MMddyy")
//    yesterday.format(formatter)
//  }
//}