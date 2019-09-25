package rationality.shapelessnat

import shapeless.{Nat, Succ}
import shapeless.ops.nat.{Diff, Prod}

trait Minus[A <: Rat, B <: Rat] {
  type Out <: Rat
}


object Minus {

  type Aux[A <: Rat, B <: Rat, Out0 <: Rat] = Minus[A, B] { type Out = Out0 }

  implicit def sum[A <: Nat, B <: Succ[_], C <: Nat, D <: Succ[_], AD <: Nat, BD <: Succ[_], CB <: Nat, DiffTop <: Nat]
  (implicit ad: Prod.Aux[A, D, AD],
   bd: Prod.Aux[B, D, BD],
   cb: Prod.Aux[C, B, CB],
   sumTop: Diff.Aux[AD, CB, DiffTop],
   simplify: Simplify[DiffTop / BD]
  ): Aux[A / B, C / D, simplify.Out] = null

}
