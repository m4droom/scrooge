/**
  * Created by seed on 2017. 6. 12..
  */
package object friday {
  type Conversion = Map[(Currency, Currency), BigDecimal]

  implicit class BigDecimalOps(val value: BigDecimal) extends AnyVal {
    def apply(currency: Currency)(implicit converter: Converter): Money =
      Money(value, currency)
  }

  implicit class IntOps(val value: Int) extends AnyVal {
    def apply(currency: Currency)(implicit converter: Converter): Money =
      (value: BigDecimal).apply(currency)
  }

  implicit class DoubleOps(val value: Double) extends AnyVal {
    def apply(currency: Currency)(implicit converter: Converter): Money =
      (value: BigDecimal).apply(currency)
  }

  implicit class ItemOps(val name: String) {
    def at(where: String): Item = Item(name, where)
  }

  implicit class PaymentOps(val who: String) {
    def purchase(itemName: String) = new {
      def at(itemWhere: String) = new {
        def for_(money: Money): Payment = {
          Payment(who, money, Item(itemName, itemWhere))
        }
      }
    }
  }
}