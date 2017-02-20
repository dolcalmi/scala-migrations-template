import Dependencies._

lazy val root = (project in file(".")).
aggregate(myApp)

lazy val myApp = (project in file("my-app")).
  settings(
    inThisBuild(List(
      organization := "com.github.dolcalmi",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

lazy val migrations = (project in file("db"))
// Create an alias for run database migrations
// db new mymigrationfile
// db migrate or db migrate version (timestamp)
// db rollback or db rollback numOfMigrations
// db reset
addCommandAlias("db", "migrations/run")
