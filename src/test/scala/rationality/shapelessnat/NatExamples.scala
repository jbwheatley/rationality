package rationality.shapelessnat

import shapeless.Nat
import shapeless.nat._

class NatExamples {


  def sum[A <: Nat, B <: Nat](implicit ev: shapeless.ops.nat.Sum[A, B]): Option[ev.Out] = Option.empty[ev.Out]
  def prod[A <: Nat, B <: Nat](implicit ev: shapeless.ops.nat.Prod[A, B]): Option[ev.Out] = Option.empty[ev.Out]


  sum[_4, _5] : Option[_9]
  sum[_3, _2] : Option[_6] //does not compile

  prod[_3, _4] : Option[_12]

  // etc...

}

