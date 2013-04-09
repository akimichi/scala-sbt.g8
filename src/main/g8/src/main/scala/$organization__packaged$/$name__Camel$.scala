package $organization$

object ExpensiveCalc {
  val NumInterations = 1000

  def expensiveCalc = calculatePiFor(0, 1000000)

  def calculatePiFor(start: Int, nrOfElements: Int): Double = {
    var acc = 0.0
    for (i <- start until (start + nrOfElements))
      acc += 4.0 * (1 - (i % 2) * 2) / (2 * i + 1)
    acc
  }
}

// object $name;format="Camel"$ extends App {
//   println("Hello, $name$")
// }
