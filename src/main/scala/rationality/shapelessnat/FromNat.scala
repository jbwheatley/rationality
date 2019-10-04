package rationality.shapelessnat

import shapeless.Nat
import shapeless.nat._1

trait FromNat[A <: Nat] {
  type Out <: Rat
}

object FromNat {

  type Aux[A <: Nat, Out0 <: Rat] = FromNat[A] { type Out = Out0 }

  implicit def fromNat[A <: Nat]: Aux[A, A / _1] = null
}