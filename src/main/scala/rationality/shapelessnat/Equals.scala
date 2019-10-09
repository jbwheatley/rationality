package rationality.shapelessnat

import shapeless.{Nat, Succ}
import shapeless.Nat._
import shapeless.ops.nat.Prod

trait Equals[A <: Rat, B <: Rat]

object Equals {

  implicit def simpleEquals1[A <: Nat, B <: Succ[_]]: Equals[A / B, A / B] = null

  implicit def simpleEquals2[B <: Succ[_], D <: Succ[_]]: Equals[_0 / B, _0 / D] = null

  implicit def multEquals[A <: Nat, B <: Succ[_], C <: Nat, D <: Succ[_], AbyD <: Nat, BbyC <: Nat]
  (
    implicit
    ev1: Prod.Aux[A, D, AbyD],
    ev2: Prod.Aux[B, C, BbyC],
    eq: AbyD =:= BbyC
  ): Equals[A / B, C / D] = null

}
