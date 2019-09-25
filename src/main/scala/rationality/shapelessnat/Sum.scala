package rationality.shapelessnat

import shapeless.ops.nat.Prod
import shapeless.{Nat, Succ}

trait Sum[A <: Rat, B <: Rat] {
  type Out <: Rat
}


object Sum {

  type Aux[A <: Rat, B <: Rat, Out0 <: Rat] = Sum[A, B] { type Out = Out0 }

  implicit def sum[A <: Nat, B <: Succ[_], C <: Nat, D <: Succ[_], AD <: Nat, BD <: Succ[_], CB <: Nat, SumTop <: Nat]
  (implicit ad: Prod.Aux[A, D, AD],
   bd: Prod.Aux[B, D, BD],
   cb: Prod.Aux[C, B, CB],
   sumTop: shapeless.ops.nat.Sum.Aux[AD, CB, SumTop],
   simplify: Simplify[SumTop / BD]
  ): Aux[A / B, C / D, simplify.Out] = null

}
