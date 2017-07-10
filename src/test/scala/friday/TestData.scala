package friday

/**
  * Created by seed on 2017. 6. 12..
  */
object TestData {

  val chulsu = "철수"

  val item_name = "사과"

  val item_where = "슈퍼"

  val dkk_krw = 169.66

  val sek_krw = 129.27

  val dkk_sek = 1.31

  val conversion: Conversion = Map(
    (DKK, KRW) -> dkk_krw,
    (SEK, KRW) -> sek_krw,
    (DKK, SEK) -> dkk_sek
  )

  implicit val convertor = Converter(conversion)
}
