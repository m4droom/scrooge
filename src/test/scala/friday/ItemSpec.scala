package friday

import java.lang.{IllegalArgumentException => IAE}

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by seed on 2017. 6. 16..
  */
class ItemSpec extends WordSpec with Matchers {

  import TestData._

  "아이템 null check" should {
    "이름이 없으면 에러" in {
      an[IAE] should be thrownBy Item(null, item_where)
    }

    "장소가 없으면 에러" in {
      an[IAE] should be thrownBy Item(item_name, null)
    }
  }

  "아이템 생성" should {
    "사과" in {
      val item = Item("사과", "슈퍼")

      item.name shouldEqual item_name
      item.where shouldEqual item_where
    }
  }
}