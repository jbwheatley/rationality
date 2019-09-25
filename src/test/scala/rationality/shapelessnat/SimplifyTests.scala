package rationality.shapelessnat

import org.scalatest.{FlatSpec, Matchers}
import shapeless.nat._
import shapeless.test.illTyped

class SimplifyTests extends FlatSpec with Matchers {

  def simplify[A <: Rat, B <: Rat](implicit ev: Simplify.Aux[A, B]): Simplify.Aux[A, B] = ev

  "simplify" should "correctly simplify fractions" in {

    simplify[_8 / _4, _2 / _1]
    simplify[_4 / _6, _2 / _3]
    simplify[_0 / _9, _0 / _1]

    illTyped("simplify[_3 / _6, _2 / _3]", ".*could not find implicit.*")
  }
}
