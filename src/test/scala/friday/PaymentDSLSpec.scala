package friday

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by seed on 2017. 6. 13..
  */
class PaymentDSLSpec extends WordSpec with Matchers {

  import TestData._

  "결제 DSL" should {
    "철수가 10 DKK 로 사과를 슈퍼에서 샀다" in {
      "철수" purchase "사과" at "슈퍼" for_ 10 (DKK) shouldEqual
        Payment("철수", Money(10, DKK), Item(item_name, item_where))
    }
  }
}