package friday

import scala.math.BigDecimal.RoundingMode

/**
  * Created by seed on 2017. 6. 12..
  */
case class Money(amount: BigDecimal = 0, currency: Currency = KRW)(implicit converter: Converter) {
  require(amount >= 0, "amount gte 0")
  require(currency != null, "currency is null")

  def to(thatCurrency: Currency): Money = {
    val rate = converter.convert(currency, thatCurrency)
    Money(amount * rate, thatCurrency)
  }

  def +(thatMoney: Money): Money =  performOperation(thatMoney, _ + _)

  def +(that: BigDecimal): Money = this + Money(that, this.currency)

  def -(that: Money): Money = performOperation(that, _ - _)

  def -(that: BigDecimal): Money = this - Money(that, this.currency)

  def performOperation(thatMoney: Money, operation: (BigDecimal, BigDecimal) => BigDecimal): Money = {
    thatMoney match {
      case Money(v, c) if c == currency => Money(operation(amount, v), currency)
      case Money(v, c) => performOperation(thatMoney.to(currency), operation)
    }
  }

  override def toString: String = {
    amount.setScale(2, RoundingMode.HALF_EVEN).toString()
  }
}