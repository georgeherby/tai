/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.tai.factory

import org.joda.time.LocalDate
import play.api.libs.json.{JsNull, JsObject, Json}
import uk.gov.hmrc.tai.model.TaxCodeRecord
import uk.gov.hmrc.tai.util.TaxCodeHistoryConstants

object TaxCodeRecordFactory extends TaxCodeHistoryConstants {

  def createPrimaryEmployment(taxCode: String = "1185L",
                              basisOfOperation: String = Cumulative,
                              employerName: String = "Employer 1",
                              dateOfCalculation: LocalDate = LocalDate.now,
                              payrollNumber: Option[String] = Some("123")): TaxCodeRecord = {

    createEmployment(taxCode, basisOfOperation, employerName, operatedTaxCode = true, dateOfCalculation, payrollNumber, Primary)
  }

  def createPrimaryEmploymentJson(taxCode: String = "1185L",
                                  basisOfOperation: String = Cumulative,
                                  employerName: String = "Employer 1",
                                  dateOfCalculation: LocalDate = LocalDate.now,
                                  payrollNumber: String = "123"): JsObject = {
    Json.obj(
      "taxCode" -> taxCode,
      "basisOfOperation" -> basisOfOperation,
      "employerName" -> employerName,
      "operatedTaxCode" -> true,
      "dateOfCalculation" -> dateOfCalculation,
      "payrollNumber" -> payrollNumber,
      "pensionIndicator" -> false,
      "employmentType" -> Primary
    )
  }

  def createSecondaryEmployment(taxCode: String = "1185L",
                                basisOfOperation: String = Cumulative,
                                employerName: String = "Employer 1",
                                dateOfCalculation: LocalDate = LocalDate.now,
                                payrollNumber: Option[String] = Some("123")): TaxCodeRecord = {

    createEmployment(taxCode, basisOfOperation, employerName, true, dateOfCalculation, payrollNumber, Secondary)
  }

  def createSecondaryEmploymentJson(taxCode: String = "1185L",
                                  basisOfOperation: String = Cumulative,
                                  employerName: String = "Employer 1",
                                  dateOfCalculation: LocalDate = LocalDate.now,
                                  payrollNumber: String = "123"): JsObject = {
    Json.obj(
      "taxCode" -> taxCode,
      "basisOfOperation" -> basisOfOperation,
      "employerName" -> employerName,
      "operatedTaxCode" -> true,
      "dateOfCalculation" -> dateOfCalculation,
      "payrollNumber" -> payrollNumber,
      "pensionIndicator" -> false,
      "employmentType" -> Secondary
    )
  }

  def createNoPayrollNumberJson(taxCode: String = "1185L",
                                basisOfOperation: String = Cumulative,
                                employerName: String = "Employer 1",
                                dateOfCalculation: LocalDate = LocalDate.now,
                                employmentType: String = Primary): JsObject = {
    Json.obj(
      "taxCode" -> taxCode,
      "basisOfOperation" -> basisOfOperation,
      "employerName" -> employerName,
      "operatedTaxCode" -> true,
      "dateOfCalculation" -> dateOfCalculation,
      "payrollNumber" -> JsNull,
      "pensionIndicator" -> false,
      "employmentType" -> employmentType
    )
  }

  def createNonOperatedEmployment(taxCode: String = "1185L",
                                  basisOfOperation: String = Cumulative,
                                  employerName: String = "Employer 1",
                                  dateOfCalculation: LocalDate = LocalDate.now,
                                  payrollNumber: Option[String] = Some("123")): TaxCodeRecord = {

    TaxCodeRecord(taxCode, basisOfOperation, employerName, operatedTaxCode = false, dateOfCalculation, payrollNumber, pensionIndicator = false, Primary)
  }


  private def createEmployment(taxCode: String,
                               basisOfOperation: String,
                               employerName: String,
                               operatedTaxCode: Boolean,
                               dateOfCalculation: LocalDate,
                               payrollNumber: Option[String],
                               employmentType: String): TaxCodeRecord = {

    TaxCodeRecord(taxCode, basisOfOperation, employerName, operatedTaxCode, dateOfCalculation, payrollNumber, pensionIndicator = false, employmentType)
  }
}