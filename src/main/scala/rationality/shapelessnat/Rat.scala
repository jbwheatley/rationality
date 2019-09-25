package rationality
package shapelessnat

import shapeless.{Nat, Succ}

trait Rat {
  type Numerator <: Nat
  type Denominator <: Succ[_]
}

object Rat {
  type Aux[A <: Nat, B <: Succ[_]] = Rat { type Numerator = A; type Denominator = B }
}
