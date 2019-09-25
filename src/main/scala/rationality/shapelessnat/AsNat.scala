package rationality.shapelessnat

import shapeless.{Nat, Succ}
import shapeless.nat._1

trait AsNat[A <: Rat] {
  type Out <: Nat
}

object AsNat {

  type Aux[A <: Rat, Out0 <: Nat] = AsNat[A] { type Out = Out0 }

  implicit def asNat[A <: Nat, B <: Succ[_], C <: Nat](implicit ev: Simplify.Aux[A / B, C / _1]): Aux[A / B, C] = null
}
