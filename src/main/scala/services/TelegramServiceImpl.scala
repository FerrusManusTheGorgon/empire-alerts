package services

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Future


class TelegramServiceImpl extends TelegramService with LazyLogging{
  val botToken = "6283092723:AAHPJn47wwxal3nVsy7o2OLTCxom7KxFBwk"
  val chatId = "-1001921543197"
  val apiUrl = s"https://api.telegram.org/bot$botToken/sendMessage"
  override def sendMessage(message: String): Unit = {
    val r = requests.post(apiUrl, data = Map("chat_id" -> chatId,"text" -> message))
    ()
  }

}





