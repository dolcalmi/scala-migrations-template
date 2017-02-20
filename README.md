# SBT Project template for Scala Migrations
This is a project template for use of [Scala Migrations](https://github.com/imageworks/scala-migrations). More simple than forklift (without symlinks and with only 1 project)

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [SBT](http://www.scala-sbt.org/download.html)
* [Docker](https://www.docker.com/) (optional if you want a quick mysql server)
* [Docker Compose](https://docs.docker.com/compose/) (optional if you want a quick mysql server)

## Supported Databases

[Scala Migrations](https://github.com/imageworks/scala-migrations) currently supports

  * Derby
  * MySQL
  * Oracle
  * PostgreSQL

## Run this Project

* `git clone git@github.com:dolcalmi/scala-migrations-template.git`
* change into the new directory
* `rm -rf .git && git init` (optional, make it yours)
* `docker-compose up`(check docker-compose.yml for details. Port 3306 must be free in localhost). If you have a test mysql server you dont need to run this command but you have to modify [migrations.conf](db/config/migrations.conf)
* `sbt`
* `db migrate` (run migrations in db/migrations/)

## How to use it in my project?

* copy `db` folder into your project directory
* add `lazy val migrations = (project in file("db"))` and `addCommandAlias("db", "migrations/run")` to your main build.sbt (Eg. in [build.sbt](build.sbt))
* Modify database connection in [migrations.conf](db/config/migrations.conf)
* If you don't use mysql please modify [db build.sbt](db/build.sbt) to include the appropriate dependency .
* reload sbt and test db commands

## Available commands

##### Create Mitrations
```shell
  > db new MyMigrationName
```
##### Mitrate
Run all migrations
```shell
  > db migrate
```
Migrate to a specific migration

```shell
  > db migrate 20170219204617
```
##### Rollback
Rollback the last migration
```shell
  > db rollback
```
Rollback the last 2 migrations
```shell
  > db rollback 2
```

##### Reset
Rollback all migrations
```shell
  > db reset
```
