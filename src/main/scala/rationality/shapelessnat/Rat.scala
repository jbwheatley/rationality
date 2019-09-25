package rationality
package shapelessnat

import shapeless.{Nat, Succ}

trait Rat {
  type Denom <: Nat
  type Numer <: Succ[_]
}

object Rat {
  type Aux[A <: Nat, B <: Succ[_]] = Rat { type Denom = A; type Numer = B }
}
