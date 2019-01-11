import scala.io.StdIn._

object Thursday extends App {

  val primeNumberList = 1 to 100 toList
  def primeNumberChecker(number:Int):Int={
    var primeCount=0
    var i =2
    for(i<- 2 to math.ceil(math.sqrt(number)).toInt){
      if(number%i==0) primeCount+=1
    }
    if(primeCount<1) 1
    else 0
  }
  var primeCount=0
  primeNumberList.foreach(test => primeCount+=primeNumberChecker(test))

  println(primeCount)

  def isFactorial(number:Int):Unit={
    var multiplier = 1
    var factorialNumber = 1
    while(multiplier<number){
      factorialNumber+=1
      multiplier=multiplier*factorialNumber
    }
    if(number==multiplier) println(s"$factorialNumber!")
    else println("NONE")
  }
  println("Please enter a number to check if it is a factorial of another number")
  isFactorial(readInt)

  def cypher():Unit={
    val alphabet = 'a' to 'z'
    println("\nEnter a string to encode or decode")
    def cypherPrinter(testString:String, plain:Array[Char], cypher:Array[Char]):Unit= {
      for(i<-0 until testString.length; j<- 0 until plain.length if testString.substring(i,i+1).charAt(0)==plain(j)) print(cypher(j))
    }
    cypherPrinter(readLine, alphabet.toArray, alphabet.reverse.toArray)
    cypher()
  }
  cypher()
}