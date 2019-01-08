object Monday extends App {
  //tasks completed up to iteration 4
  println("Hello world")

  val message = "hello world"
  println(message)

  def printWord(message: String)= println(message)

  printWord("Hello world")

  def helloWorld2():String = "hello world"

  println(helloWorld2())

  def strings(message: String, b: Int): String = message.substring(message.length - b, message.length)

  println(strings("hello", 3))

  def strings2(firstString: String, secondString: String, firstChar: Char, secondChar: Char): String = {
    val combination = firstString + secondString
    var myreturn = ""

    for (i <- 0 until combination.length) {
      if (combination.substring(i, i + 1) == firstChar.toString) myreturn = myreturn + secondChar
      else myreturn += combination.substring(i, i + 1)
    }
    myreturn
  }

  println(strings2("Ha", "llo", 'a', 'e'))

  def conditionals(firstInt: Int, secondInt: Int, bool: Boolean): Int = {
    if (firstInt == 0 || secondInt == 0){
      if (secondInt > firstInt) secondInt
      else firstInt
    }
    else if (bool) firstInt + secondInt
    else firstInt * secondInt
  }

  println(conditionals(0, 3, 3 != 3))

  def iteration(myString: String, loops: Int) {
    for (i <- 1 to loops) println(myString)
  }

  iteration("H", 4)


  def iteration2(myString: String, loops: Int) {
    for (i <- 1 to loops) println(myString*loops)
  }

  iteration2("H", 4)

  def iteration3(firstWord: String, secondWord: String, num1: Int) {
    for (i <- 1 to num1) {
      num1 match{
        case fb if i % 3 == 0 && i % 5 == 0 => print(firstWord + secondWord)
        case f if i % 3 == 0 => print(firstWord)
        case b if i % 5 ==0 => print(secondWord)
        case _ => print(i)
      }
      if (i != num1) {
        print(",")
      }
    }
  }

  iteration3("Fizz", "Buzz", 15)
  println("")

  def recursion(myString: String, b: Int) {
    if (b > 0) {
      println(myString)
      recursion(myString, b - 1)
    }
  }

  recursion("H", 4)

  def recursion2(myString: String, b: Int) {

    val columns = b
    if (b > 0) {
      println(myString*b)
      recursion2(myString, b - 1)

    }
  }

  recursion2("H", 4) //needs work, reduces the amount of times it prints the string with each turn

  def recursion3(a: String, b: String, num1: Int):String = {
    var output = ""
    logicChecks(a, b, num1)

    def logicChecks(firstWord: String, secondWord: String, num1: Int):Unit={
      if (num1 > 0) {
        num1 match{
          case a if num1 % 3 == 0 && num1 % 5 == 0 => output = firstWord + secondWord + output
          case b if num1 % 3 == 0 => output = firstWord + output
          case c if num1 % 5 == 0 => output = secondWord + output
          case _ => output = num1.toString + output
        }
        if(num1!=1) output = "," + output
        logicChecks(firstWord, secondWord, num1 - 1)
      }
    }
    output
  }
  println(recursion3("Fizz", "Buzz", 15))
}