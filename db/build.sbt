name := "scala-migrations"
scalaVersion := "2.11.8"
version := "0.1.0"
organization := "com.github.dolcalmi.scala-migrations-template"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.imageworks.scala-migrations" %% "scala-migrations" % "1.1.1",
  "org.rogach" %% "scallop" % "2.1.0",
  "com.typesafe" % "config" % "1.3.0",
  // or load other driver
  "mysql" % "mysql-connector-java" % "5.1.34"
)

// Don't use sbt default directory structure we need it simple
sourcesInBase := false
resourceDirectory in Compile := baseDirectory.value / "config"
unmanagedSourceDirectories in Compile += baseDirectory.value / "utils"

// must be the same than cofig/migrations.conf
unmanagedSourceDirectories in Compile += baseDirectory.value / "migrations"
