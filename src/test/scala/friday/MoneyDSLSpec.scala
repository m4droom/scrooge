package friday

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by seed on 2017. 6. 12..
  */
class MoneyDSLSpec extends WordSpec with Matchers {

  import TestData._

  "1000 (KRW)" should {
    "Money(1000, KRW)" in {
      1000 (KRW) shouldEqual Money(1000, KRW)
    }
  }

  "12.3 (DKK)" should {
    "Money(12.3, DKK)" in {
      12.3 (DKK) shouldEqual Money(12.3, DKK)
    }
  }

  "1.123456789012345 (SEK)" should {
    "Money(1.123456789012345, SEK)" in {
      1.123456789012345 (SEK) shouldEqual Money(1.123456789012345, SEK)
    }
  }
}
