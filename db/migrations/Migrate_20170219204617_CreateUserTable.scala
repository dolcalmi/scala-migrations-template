package com.github.dolcalmi.migrations

import com.imageworks.migration._

/**
 * authoredAt: 1487555177124
 */

class Migrate_20170219204617_CreateUserTable extends Migration
{
  val tableName = "users"
  def up() {
    createTable(tableName) { t =>
      t.bigint("id", PrimaryKey, AutoIncrement)

      t.varchar("first_name", Limit(45), NotNull)
      t.varchar("last_name", Limit(45), NotNull)
      t.varchar("email", Limit(255), Unique, NotNull)
      t.varchar("password", Limit(255), NotNull)

      t.boolean("email_verified", Default(0))
      t.bigint("email_verified_at")

      t.bigint("updated_at", NotNull)
      t.bigint("created_at", NotNull)
    }
  }

  def down() {
    dropTable(tableName)
  }
}
