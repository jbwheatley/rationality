package rationality.shapelessnat

import shapeless.{Nat, Succ}
import shapeless.nat._

trait Ceiling[A <: Rat] {
  type Out <: Rat
}

object Ceiling {
  type Aux[A <: Rat, Out0 <: Rat] = Ceiling[A] { type Out = Out0 }

  implicit def ceiling[A <: Rat, C <: Nat](
    implicit floor: Floor.Aux[A, C / _1]
  ): Aux[A, Succ[C] / _1] = null
}

trait CeilingNat[A <: Rat] {
  type Out <: Nat
}

object CeilingNat {
  type Aux[A <: Rat, Out0 <: Nat] = CeilingNat[A] { type Out = Out0 }

  implicit def ceiling[A <: Rat, C <: Nat](
    implicit ceiling: Ceiling.Aux[A, C / _1]
  ): Aux[A, C] = null
}
