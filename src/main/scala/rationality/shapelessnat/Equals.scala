package rationality.shapelessnat

import shapeless.{Nat, Succ}
import shapeless.Nat._

trait Equals[A <: Rat, B <: Rat]

object Equals {

  implicit def simpleEquals1[A <: Nat, B <: Succ[_]]: Equals[A / B, A / B] = null

  implicit def simpleEquals2[B <: Succ[_], D <: Succ[_]]: Equals[_0 / B, _0 / D] = null

  implicit def simplifyThenEquals[A <: Nat, B <: Succ[_], C <: Nat, D <: Succ[_], AbyBSimp <: Rat, CbyDSimp <: Rat]
  (
    implicit
    ev1: Simplify.Aux[A / B, AbyBSimp],
    ev2: Simplify.Aux[C / D, CbyDSimp],
    eq: Equals[AbyBSimp, CbyDSimp]
  ): Equals[A / B, C / D] = null

}
