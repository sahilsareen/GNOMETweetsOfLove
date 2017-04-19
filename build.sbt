name := "GNOMETweetsOfLove"

version := "1.0"

scalaVersion := "2.11.8"

unmanagedJars in Compile += file("lib/gtk.jar")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming" % "2.1.0",
  "org.apache.bahir" %% "spark-streaming-twitter" % "2.1.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)