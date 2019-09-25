package rationality

import shapeless.{Nat, Succ}
import shapelessnat.Rat._
import shapeless.nat._

package object shapelessnat {

  type /[A <: Nat, B <: Succ[_]] = Aux[A, B]
  type x[A <: Rat, B <: Rat] = Mult[A, B]
  type +[A <: Rat, B <: Rat] = Sum[A, B]
  type -[A <: Rat, B <: Rat] = Minus[A, B]

  type <[A <: Rat, B <: Rat] = LessThan[A, B]
  type <=[A <: Rat, B <: Rat] = LessThanEquals[A, B]
  type >[A <: Rat, B <: Rat] = GreaterThan[A, B]
  type >=[A <: Rat, B <: Rat] = GreaterThanEquals[A, B]

  type ===[A <: Rat, B <: Rat] = Equals[A, B]
  type =/=[A <: Rat, B <: Rat] = NotEquals[A, B]

  type Half = _1 / _2
  type Third = _1 / _3
  type Quarter = _1 / _4
}
