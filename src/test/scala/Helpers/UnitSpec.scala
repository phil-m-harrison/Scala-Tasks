package Helpers
import org.scalatest._
import collection.mutable.Stack
import org.scalatest.Assertions._

abstract class UnitSpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors {

}
//
//
//class StackSpec extends _root_.UnitSpec {
//
//  "A Stack" should "pop values in last-in-first-out order" in {
//    val stack = new Stack[Int]
//    stack.push(1)
//    stack.push(2)
//    assert(stack.pop() === 2)
//    assert(stack.pop() === 1)
//  }
//
//  it should "throw NoSuchElementException if an empty stack is popped" in {
//    val emptyStack = new Stack[String]
//    assertThrows[NoSuchElementException] {
//      emptyStack.pop()
//    }
//  }
//}
//
//class assertTests extends _root_.UnitSpec{
////  val left = 2
////  val right = 1
////  assert(left == right)
//  val num = 1.0
//
//  assert("hello".startsWith("h") && "goodbye".endsWith("y"))
//  assert(num.isInstanceOf[Int])
//}