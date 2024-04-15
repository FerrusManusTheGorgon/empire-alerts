import akka.actor.ActorSystem
import com.typesafe.scalalogging.LazyLogging
import services.EmpireArmsChecker


object Main2 extends App with LazyLogging {

  // Define the fixed base URL
  val baseUrl = "https://www.empirearms.com/"

  // Create an implicit ActorSystem
  implicit val system: ActorSystem = ActorSystem("EmpireArmsCheckerSystem")

  // Create an instance of EmpireArmsChecker with the fixed base URL
  val empireArmsChecker = new EmpireArmsChecker(baseUrl)

  // Run the EmpireArmsChecker
  empireArmsChecker.run()


}



