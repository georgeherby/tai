/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.tai.model.domain

import org.joda.time.LocalDate
import com.github.nscala_time.time.Imports._

case class Payment(
                    date: LocalDate,
                    amountYearToDate: BigDecimal,
                    taxAmountYearToDate: BigDecimal,
                    nationalInsuranceAmountYearToDate: BigDecimal,
                    amount: BigDecimal,
                    taxAmount: BigDecimal,
                    nationalInsuranceAmount: BigDecimal,
                    payFrequency : PaymentFrequency
                  ) extends Ordered[Payment] {

  def compare(that: Payment): Int = this.date compare that.date
}

object Payment {
  implicit val dateOrdering: Ordering[Payment] = Ordering.by(_.date.toDate())
}
