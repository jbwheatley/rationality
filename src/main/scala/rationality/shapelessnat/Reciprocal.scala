package rationality.shapelessnat

import shapeless.Succ

trait Reciprocal[A <: Rat] {
  type Out <: Rat
}

object Reciprocal {

  type Aux[A <: Rat, Out0 <: Rat] = Reciprocal[A] { type Out = Out0 }

  implicit def recipr[A <: Succ[_], B <: Succ[_]]: Aux[A / B, B / A] = null
}
