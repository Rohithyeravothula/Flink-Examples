name := "Flink-Test"

version := "1.0"

scalaVersion := "2.10.4"

val flinkVersion = "1.0.3"

libraryDependencies += "org.apache.flink" % "flink-scala_2.10" % flinkVersion

libraryDependencies += "org.apache.flink" % "flink-clients_2.10" % flinkVersion

libraryDependencies += "org.apache.flink" % "flink-streaming-scala_2.10" % flinkVersion
