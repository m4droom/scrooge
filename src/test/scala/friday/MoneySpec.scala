package friday

import java.lang.{IllegalArgumentException => IAE}

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by seed on 2017. 6. 13..
  */
class MoneySpec extends WordSpec with Matchers {

  import TestData._

  "화폐 생성" should {
    "0 보다 작으면 에러" in {
      an[IAE] should be thrownBy Money(-1, KRW)
    }
  }

  "화폐 생성" should {
    "기본값은 0 원" in {
      val krw0 = Money()
      krw0.amount shouldEqual 0
      krw0.currency shouldEqual KRW
    }
  }

  "화폐 환전" should {
    "1 DKK 는 169.66 KRW" in {
      Money(1, DKK).to(KRW) shouldEqual Money(169.66, KRW)
    }

    "1 SEK 는 129.27 KRW" in {
      Money(1, SEK).to(KRW) shouldEqual Money(129.27, KRW)
    }

    "1 DKK 는 1.31 SEK" in {
      Money(1, DKK).to(SEK) shouldEqual Money(1.31, SEK)
    }
  }

  "화폐 더하기" should {
    "1000 KRW + 2000 KRW = 3000 KRW" in {
      (Money(1000, KRW) + Money (2000, KRW)) shouldEqual Money(3000, KRW)
    }

    "1000 KRW + 20 DKK = 4393.20 KRW" in {
      (Money(1000, KRW) + Money (20, DKK)) shouldEqual Money(4393.20, KRW)
    }

    "1000 KRW + 20 SEK = 3585.49 KRW" in {
      (Money(1000, KRW) + Money (20, SEK)) shouldEqual Money(3585.40, KRW)
    }

    "20 DKK + 1000 KRW = 27.74 DKK" in {
      val s: String = "27.735746886361878239344008664036513"
      val b: BigDecimal = BigDecimal(s)
      (Money (20, SEK) + Money(1000, KRW)) shouldEqual Money(b, SEK)
    }
  }
}
