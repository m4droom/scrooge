package friday

import org.scalatest.{Matchers, WordSpec}


/**
  * Created by seed on 2017. 6. 19..
  */
class ItemDSLSpec extends WordSpec with Matchers {

  import TestData._

  "아이템 생성" should {
    "슈퍼에 사과" in {
      "사과" at "슈퍼" shouldEqual Item(item_name, item_where)
    }
  }
}
