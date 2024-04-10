//package services
//
//import com.typesafe.scalalogging.LazyLogging
//import services.EmpireArmsService
//
//import scala.concurrent.Future
//
//
//class EmpireArmsServiceImpl extends EmpireArmsService with LazyLogging {
//  //  override def isValidUrl(url: String): Boolean = {
//  //    val status = requests.get(url, readTimeout = 1000, check = false).statusCode
//  //    if (status == 200) {
//  //      true
//  //    } else {
//  //      false
//  //    }
//  //
//  //  }
//  //
//  //}
//  override def isValidUrl(url: String): Boolean = {
//    try {
//      val response = requests.get(url, readTimeout = 1000, connectTimeout = 10000, check = false)
//      val status = response.statusCode
//      println(s"URL: $url, Status code: $status")
//      status == 200 && status != 404
//    } catch {
//      case _: requests.TimeoutException =>
//        println(s"URL: $url, Request timed out")
//        false
//    }
//  }
//
//
//}
//
