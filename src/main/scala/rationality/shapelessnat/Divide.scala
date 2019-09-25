package rationality.shapelessnat

import shapeless.Succ

trait Divide[A <: Rat, B <: Rat] {
  type Out <: Rat
}

object Divide {

  type Aux[A <: Rat, B <: Rat, Out0 <: Rat] = Divide[A, B] { type Out = Out0 }

  implicit def divide[A <: Rat, C <: Succ[_], D <: Succ[_]](implicit ev: Mult[A, D / C]): Aux[A, C / D, ev.Out] = null
}
