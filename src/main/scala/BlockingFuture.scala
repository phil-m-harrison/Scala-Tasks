import scala.concurrent.{Await, Future}
import scala.concurrent.duration._ // Allows us to define time in the "10 seconds"format
import scala.concurrent.ExecutionContext.Implicits.global // Is required

object BlockingFuture extends App {
  def sleep(time: Long) {Thread.sleep(time)}
  val futureResult = Future {
    sleep(5000)
    35 + 53
  }
  val result = Await.result(futureResult, 10 seconds)
  println(result)
  sleep(2000) // need to keep the JVM running
}

import scala.util.{Failure, Random, Success}

object OnCompleteFuture extends App {
  def sleep(time: Long) {Thread.sleep(time)}
  val futureResult = Future {
    sleep(Random.nextInt(500))
    35 + 53
  }
  futureResult.onComplete {
    case Success(value) => println(s"The value computed is: $value")
    case Failure(error) => error.printStackTrace()
  }
  println("1 ...."); sleep(150)
  println("2 ...."); sleep(150)
  println("3 ...."); sleep(150)
  println("4 ...."); sleep(150)
  sleep(2000) // need to keep the JVM running
}

object FunctionsReturningFutures {
  def sleep(time: Long) {Thread.sleep(time)}
  def futureResult() = Future {
    sleep(Random.nextInt(500))
    35 + 53
  }
  futureResult().onComplete {
    case Success(value) => println(s"The value computed is: $value")
    case Failure(error) => error.printStackTrace()
  }
  println("1 ...."); sleep(150)
  println("2 ...."); sleep(150)
  println("3 ...."); sleep(150)
  println("4 ...."); sleep(150)
  sleep(2000) // need to keep the JVM running

}