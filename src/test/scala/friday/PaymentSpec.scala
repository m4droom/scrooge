package friday

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by seed on 2017. 6. 13..
  */
class PaymentSpec extends WordSpec with Matchers {

  import TestData._

  "결제 생성" should {
    "철수가 10 DKK 로 사과를 슈퍼에서 샀다" in {
      val p: Payment = Payment("철수", Money(10, DKK), Item("사과", "슈퍼"))

      p.who shouldEqual chulsu
      p.money shouldEqual Money(10, DKK)
      p.item shouldEqual Item(item_name, item_where)
    }
  }
}
