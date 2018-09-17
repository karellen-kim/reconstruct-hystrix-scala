name := "reconstruct-hystrix-scala"

version := "0.1"

scalaVersion := "2.12.6"

lazy val versions = new {
  val scalatest = "3.0.5"
  val rxscala = "0.26.5"
}

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % versions.scalatest,
  "io.reactivex" %% "rxscala" % versions.rxscala
)