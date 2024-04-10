package services

import scala.concurrent.Future

trait TelegramService {
  def sendMessage(message: String): Unit
}
