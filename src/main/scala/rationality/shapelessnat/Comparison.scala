package rationality.shapelessnat

import shapeless.{=:!=, Nat, Succ}
import shapeless.ops.nat.{LT, Prod}

trait LessThan[A <: Rat, B <: Rat]

object LessThan {

  implicit def equalDenominators[A <: Nat, B <: Succ[_], C <: Nat](implicit lt: LT[A, C]): LessThan[A / B, C / B] = null

  implicit def equalNumerators[A <: Nat, B <: Succ[_], D <: Succ[_]](implicit lt: LT[D, B]): LessThan[A / B, A / D] = null

  implicit def nonEqualDenominatorsAndNumerators[A <: Nat, B <: Succ[_], C <: Nat, D <: Succ[_], AD <: Nat, CB <: Nat]
  (implicit
   ev1: A =:!= C,
   ev2: B =:!= D,
   ad: Prod.Aux[A, D, AD],
   cb: Prod.Aux[C, B, CB],
   lt: LT[AD, CB]
  ): LessThan[A / B, C / D] = null
}

trait LessThanEquals[A <: Rat, B <: Rat]

object LessThanEquals {

  implicit def lessThan[A <: Rat, B <: Rat](implicit lt: LessThan[A, B]): LessThanEquals[A, B] = null
  implicit def equals[A <: Rat, B <: Rat](implicit eq: Equals[A, B]): LessThanEquals[A, B] = null

}

trait GreaterThan[A <: Rat, B <: Rat]

object GreaterThan {

  implicit def greaterThan[A <: Rat, B <: Rat](implicit lt: LessThan[B, A]): GreaterThan[A, B] = null

}

trait GreaterThanEquals[A <: Rat, B <: Rat]

object GreaterThanEquals {

  implicit def greaterThanEquals[A <: Rat, B <: Rat](implicit lte: LessThanEquals[B, A]): GreaterThanEquals[A, B] = null
}

trait NotEquals[A <: Rat, B <: Rat]

object NotEquals {
  implicit def aLessThanB[A <: Rat, B <: Rat](implicit lt: LessThan[A, B]): NotEquals[A, B] = null
  implicit def bLessThanA[A <: Rat, B <: Rat](implicit lt: LessThan[B, A]): NotEquals[A, B] = null
}