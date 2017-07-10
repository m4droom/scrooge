package friday

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by seed on 2017. 6. 16..
  */
class ConverterSpec extends WordSpec with Matchers {

  import TestData._

  "환전" should {
    "DKK:KRW 환율" in {
      convertor.convert(DKK, KRW) shouldEqual dkk_krw
    }

    "SEK:KRW 환율" in {
      convertor.convert(SEK, KRW) shouldEqual sek_krw
    }

    "DKK:SEK 환율" in {
      convertor.convert(DKK, SEK) shouldEqual dkk_sek
    }
  }
}
