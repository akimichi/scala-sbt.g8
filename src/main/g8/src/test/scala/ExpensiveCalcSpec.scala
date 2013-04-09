import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{ FunSpec, BeforeAndAfterAll, BeforeAndAfterEach }

class ExpensiveCalcSpec extends FunSpec with ShouldMatchers with BeforeAndAfterAll {
  import sample._
  
  describe("Example"){
    it("1 + 1 = 2") {
      1 + 1 should equal {
        2
      }
    }
    it("ExpensiveCalc"){
      ExpensiveCalc.expensiveCalc should equal {
        3.1415916535897743
      }
    }
  }
}
