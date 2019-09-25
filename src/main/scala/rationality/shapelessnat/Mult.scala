package rationality.shapelessnat

import shapeless.{Nat, Succ}
import shapeless.ops.nat.Prod

trait Mult[A <: Rat, B <: Rat] {
  type Out <: Rat
}


object Mult {

  type Aux[A <: Rat, B <: Rat, Out0 <: Rat] = Mult[A, B] { type Out = Out0 }

  implicit def multiply[A <: Nat, B <: Succ[_], C <: Nat, D <: Succ[_], ResTop <: Nat, ResBottom <: Succ[_]]
  (implicit
   ac: Prod.Aux[A, C, ResTop],
   bd: Prod.Aux[B, D, ResBottom],
   simplify: Simplify[ResTop / ResBottom]
  ): Aux[A / B, C / D, simplify.Out] = null
}