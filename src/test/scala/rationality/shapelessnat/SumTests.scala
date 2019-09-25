package rationality.shapelessnat

import org.scalatest.{FlatSpec, Matchers}
import shapeless.nat._

class SumTests extends FlatSpec with Matchers {

  def sum[A <: Rat, B <: Rat](implicit ev: A + B): Option[ev.Out] = Option.empty[ev.Out]

  "sum" should "correctly sum fractions" in {

    sum[_2 / _5, _2 / _5]: Option[_4 / _5]
    sum[Quarter, Half]: Option[_3 / _4]
    sum[_3 / _2, _2 / _5]: Option[_19 / _10]
  }
}
