package rationality.shapelessnat

import org.scalatest.FlatSpec
import shapeless.nat._

class ComparisonTests extends FlatSpec {

  def lessThan[A <: Rat, B <: Rat](implicit ev: A < B): A < B = ev

  "less than" should "correctly compare fractions" in {

    lessThan[_4 / _5, _7 / _8]
    lessThan[_1 / _3, _1 / _2]
    lessThan[_2 / _5, _3 / _5]
  }
}
