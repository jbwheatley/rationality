package rationality.shapelessnat

import shapeless.{Nat, Succ, _0}
import shapeless.ops.nat._
import shapeless.nat._

trait Floor[A <: Rat] {
  type Out <: Rat
}

object Floor {
  type Aux[A <: Rat, Out0 <: Rat] = Floor[A] { type Out = Out0 }

  implicit def floor[A <: Nat, B <: Succ[_], C <: Nat](implicit div: Div.Aux[A, B, C]): Aux[A / B, C / _1] = null
}

trait FloorNat[A <: Rat] {
  type Out <: Nat
}

object FloorNat {
  type Aux[A <: Rat, Out0 <: Nat] = FloorNat[A] { type Out = Out0 }

  implicit def floor[A <: Rat, C <: Nat](
    implicit floor: Floor.Aux[A, C / _1]
  ): Aux[A, C] = null
}