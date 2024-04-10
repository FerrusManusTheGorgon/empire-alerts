package services

import org.mockito.Mockito.when
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
//import org.mockito.MockitoSugar._
import org.scalatestplus.mockito.MockitoSugar.mock
import requests.RequestFailedException
import services.TelegramServiceImpl

class TelegramServiceImplSpec extends AnyFunSpec with Matchers {

  describe("TelegramServiceImpl") {
    it("should send a message via Telegram API") {

      val testHtml = "https://www.empirearms.com/"

      val manager = new TelegramServiceImpl

      val result = manager.sendMessage(testHtml)

      assert(result == ())

    }
  }
}
