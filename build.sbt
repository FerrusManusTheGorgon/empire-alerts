ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "empire-alerts"
  )
libraryDependencies ++= Seq(
  "com.lihaoyi" %% "requests" % "0.8.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  "org.scalatestplus" %% "mockito-3-4" % "3.2.9.0" % Test,
  "com.typesafe.akka" %% "akka-actor" % "2.6.19"


)
