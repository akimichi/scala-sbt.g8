import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{ FunSpec, BeforeAndAfterAll, BeforeAndAfterEach }

class ExampleSpec extends FunSpec with ShouldMatchers with BeforeAndAfterAll {
  describe("Example"){
    it("1 + 1 = 2") {
      1 + 1 should equal {
        2
      }
    }
  }
}
