import Helpers.UnitSpec
import org.scalatest._

class CalculatorTester extends UnitSpec{
  assert(Calculator.add(1,2)==3)
  "Calculator functions" should "throw error with an incorrect assumption" in {
    assert(Calculator.multiply(3,4)==12 || Calculator.add(3,4)==8)
    assert(Calculator.subtract(3,6)== -3)

  }
}
