package rationality

import shapeless.{Nat, Succ}
import shapelessnat.Rat._
import shapeless.nat._

package object shapelessnat {

  type /[A <: Nat, B <: Succ[_]] = Aux[A, B]

  type ===[A <: Rat, B <: Rat] = Equals[A, B]

  type *[A <: Rat, B <: Rat] = Mult[A, B]

  type Half = _1 / _2
  type Third = _1 / _3
  type Quarter = _1 / _4
}
