package friday

/**
  * Created by seed on 2017. 6. 11..
  */
trait Currency {
  def code: String
}

object Currency {
  def apply(s: String): Currency = s.toUpperCase match {
    case "KRW" => KRW
    case "DKK" => DKK
    case "SEK" => SEK
  }
}

object KRW extends Currency {
  val code: String = "KRW"
}

object DKK extends Currency {
  val code: String = "DKK"
}

object SEK extends Currency {
  val code: String = "SEK"
}