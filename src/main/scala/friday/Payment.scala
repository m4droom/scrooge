package friday

import java.util.{Calendar, Date}

/**
  * Created by seed on 2017. 6. 13..
  */
case class Payment(who: String, money: Money, item: Item)(implicit date: Date = Calendar.getInstance.getTime) {
  require(who != null, "who is null")
  require(money != null, "money is null")
  require(item != null, "item is null")
  require(date != null, "when is null")

  def when:Date = date
}