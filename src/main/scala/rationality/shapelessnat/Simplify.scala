package rationality.shapelessnat

import shapeless.ops.nat.{Div, GCD}
import shapeless.{Nat, Succ}

trait Simplify[A <: Rat] {
 type Out <: Rat
}

object Simplify {

  type Aux[A <: Rat, B <: Rat] = Simplify[A] { type Out = B }

  implicit def simplify[A <: Nat, B <: Succ[_], _GCD <: Nat, divBOut <: Succ[_]]
  (implicit gcd: GCD.Aux[A, B, _GCD], divA: Div[A, _GCD], divB: Div.Aux[B, _GCD, divBOut]): Aux[A / B, divA.Out / divBOut] = null
}
