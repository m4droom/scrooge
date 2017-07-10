import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

val f: Future[String] = Future {
  Thread.sleep(1000)
  "hello"
}

Await.result(f, 2 seconds)


implicit val a: Int = 3

def plusValue(paramX: Int)(implicit paramY: Int) = paramX + paramY

plusValue(2)

implicit class StringInc(val s: String) {
  def inc = s.map(c => (c + 1).toChar)
}

"HAL".inc