package org.apache.carbondata.integration.spark.testsuite.timeseries

import org.apache.spark.sql.test.util.QueryTest
import org.scalatest.BeforeAndAfterAll

class TestTimeSeriesCreateTable extends QueryTest with BeforeAndAfterAll {

  override def beforeAll: Unit = {
    sql("drop table if exists mainTable")
    sql("CREATE TABLE mainTable(dataTime timestamp, name string, city string, age int) STORED BY 'org.apache.carbondata.format'")
    sql("create datamap agg0 on table mainTable using 'preaggregate' DMPROPERTIES ('timeseries.eventTime'='dataTime', 'timeseries.hierarchy'='second=1,hour=1,day=1,month=1,year=1') as select dataTime, sum(age) from mainTable group by dataTime")
  }

  test("test timeseries create table Zero") {
    checkExistence(sql("DESCRIBE FORMATTED mainTable_agg0_second"), true, "maintable_agg0_second")
    sql("drop datamap agg0_second on table mainTable")
  }

  test("test timeseries create table One") {
    checkExistence(sql("DESCRIBE FORMATTED mainTable_agg0_hour"), true, "maintable_agg0_hour")
    sql("drop datamap agg0_hour on table mainTable")
  }
  test("test timeseries create table two") {
    checkExistence(sql("DESCRIBE FORMATTED maintable_agg0_day"), true, "maintable_agg0_day")
    sql("drop datamap agg0_day on table mainTable")
  }
  test("test timeseries create table three") {
    checkExistence(sql("DESCRIBE FORMATTED mainTable_agg0_month"), true, "maintable_agg0_month")
    sql("drop datamap agg0_month on table mainTable")
  }
  test("test timeseries create table four") {
    checkExistence(sql("DESCRIBE FORMATTED mainTable_agg0_year"), true, "maintable_agg0_year")
    sql("drop datamap agg0_year on table mainTable")
  }

  test("test timeseries create table five") {
    try {
      sql(
        "create datamap agg0 on table mainTable using 'preaggregate' DMPROPERTIES ('timeseries.eventTime'='dataTime', 'timeseries.hierarchy'='sec=1,hour=1,day=1,month=1,year=1') as select dataTime, sum(age) from mainTable group by dataTime")
      assert(false)
    } catch {
      case _:Exception =>
        assert(true)
    }
  }

  test("test timeseries create table Six") {
    try {
      sql(
        "create datamap agg0 on table mainTable using 'preaggregate' DMPROPERTIES ('timeseries.eventTime'='dataTime', 'timeseries.hierarchy'='hour=2') as select dataTime, sum(age) from mainTable group by dataTime")
      assert(false)
    } catch {
      case _:Exception =>
        assert(true)
    }
  }

  test("test timeseries create table seven") {
    try {
      sql(
        "create datamap agg0 on table mainTable using 'preaggregate' DMPROPERTIES ('timeseries.eventTime'='dataTime', 'timeseries.hierarchy'='hour=1,day=1,year=1,month=1') as select dataTime, sum(age) from mainTable group by dataTime")
      assert(false)
    } catch {
      case _:Exception =>
        assert(true)
    }
  }

  test("test timeseries create table Eight") {
    try {
      sql(
        "create datamap agg0 on table mainTable using 'preaggregate' DMPROPERTIES ('timeseries.eventTime'='name', 'timeseries.hierarchy'='hour=1,day=1,year=1,month=1') as select name, sum(age) from mainTable group by name")
      assert(false)
    } catch {
      case _:Exception =>
        assert(true)
    }
  }

  test("test timeseries create table Nine") {
    try {
      sql(
        "create datamap agg0 on table mainTable using 'preaggregate' DMPROPERTIES ('timeseries.eventTime'='dataTime', 'timeseries.hierarchy'='hour=1,day=1,year=1,month=1') as select name, sum(age) from mainTable group by name")
      assert(false)
    } catch {
      case _:Exception =>
        assert(true)
    }
  }
  override def afterAll: Unit = {
    sql("drop table if exists mainTable")
  }
}
