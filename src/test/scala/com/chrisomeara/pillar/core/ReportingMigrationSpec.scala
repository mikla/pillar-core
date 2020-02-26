package com.chrisomeara.pillar.core

import com.datastax.driver.core.Session
import org.mockito.Mockito._
import org.scalatest.{FunSpec, Matchers}
import org.scalatestplus.mockito.MockitoSugar

class ReportingMigrationSpec extends FunSpec with Matchers with MockitoSugar {
  val reporter = mock[Reporter]
  val wrapped = mock[Migration]
  val migration = new ReportingMigration(reporter, wrapped)
  val session = mock[Session]

  describe("#executeUpStatement") {
    migration.executeUpStatement(session)

    it("reports the applying action") {
      verify(reporter).applying(wrapped)
    }

    it("delegates to the wrapped migration") {
      verify(wrapped).executeUpStatement(session)
    }
  }

  describe("#executeDownStatement") {
    migration.executeDownStatement(session)

    it("reports the reversing action") {
      verify(reporter).reversing(wrapped)
    }

    it("delegates to the wrapped migration") {
      verify(wrapped).executeDownStatement(session)
    }
  }
}
