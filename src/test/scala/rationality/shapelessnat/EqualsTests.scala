package rationality.shapelessnat

import org.scalatest.{FlatSpec, Matchers}
import shapeless.Nat._
import shapeless._
import shapeless.test.illTyped

class EqualsTests extends FlatSpec with Matchers {

  def equality[A <: Rat, B <: Rat](implicit ev: A === B): A === B = ev

  "equals" should "correctly check equality of fractions" in {

    equality[_3 / _1, _6 / _2]
    equality[_6 / _2, _3 / _1]
    equality[_2 / _6, _3 / _9]
    equality[_2 / _5, _2 / _5]
    equality[_0 / _1, _0 / _5]

    illTyped("equality[_1 / _2, _2 / _5]", ".*could not find implicit value*")
  }
}
