package rationality.shapelessnat

import org.scalatest.{FlatSpec, Matchers}
import shapeless.test.illTyped
import shapeless.nat._

class MultTests extends FlatSpec with Matchers {

  def multiply[A <: Rat, B <: Rat](implicit ev: Mult[A, B]): Option[ev.Out] = Option.empty[ev.Out]

  "multiply" should "correctly multiply fractions" in {

    multiply[_2 / _5, _3 / _2] : Option[_3 / _5]
    multiply[_1 / _2, _0 / _1] : Option[_0 / _1]
    multiply[_1 / _2, _1 / _4] : Option[_1 / _8]

  }
}
