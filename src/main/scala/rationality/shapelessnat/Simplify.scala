package rationality.shapelessnat

import shapeless.ops.nat.{Div, GCD}
import shapeless.{=:!=, Nat, Succ, _0}
import shapeless.nat._1

trait Simplify[A <: Rat] {
 type Out <: Rat
}

object Simplify {

  type Aux[A <: Rat, B <: Rat] = Simplify[A] { type Out = B }

  implicit def zeroCase[B <: Succ[_]]: Aux[_0 / B, _0 / _1] = null

  implicit def simplify[A <: Nat, B <: Succ[_], _GCD <: Nat, divBOut <: Succ[_]]
  (implicit gcd: GCD.Aux[A, B, _GCD],
   divA: Div[A, _GCD],
   divB: Div.Aux[B, _GCD, divBOut],
   ev: A =:!= _0
  ): Aux[A / B, divA.Out / divBOut] = null
}
