object Monday extends App {
  //tasks completed up to iteration 4
  println("Hello world")

  var a = "hello world"
  println(a)

  def printWord(a: String)= println(a)

  printWord("Hello world")

  def helloWorld2():String = "hello world"

  println(helloWorld2())


  def strings(a: String, b: Int): String = a.substring(a.length - b, a.length)

  println(strings("hello", 3))

  def strings2(a: String, b: String, c: Char, d: Char): String = {
    val combination = a + b
    var myreturn = ""

    for (i <- 0 until combination.length) {
      if (combination.substring(i, i + 1) == c.toString) {
        myreturn = myreturn + d

      }
      else {
        myreturn += combination.substring(i, i + 1)
      }

    }
    myreturn
  }

  println(strings2("Ha", "llo", 'a', 'e'))

  def conditionals(a: Int, b: Int, bool: Boolean): Int = {
    if (a == 0 || b == 0) {
      if (b > a) {
        b
      }
      else {
        a
      }
    }
    else if (bool) {
      a + b
    }
    else {
      a * b
    }
  }

  println(conditionals(0, 3, 3 != 3))

  def iteration(myString: String, b: Int) {
    for (i <- 1 to b) {
      println(myString)
    }
  }

  iteration("H", 4)


  def iteration2(myString: String, b: Int) {
    for (i <- 1 to b) {
      for (i <- 1 to b) {
        print(myString)
      }
      print("\n")
    }
  }

  iteration2("H", 4)

  def iteration3(firstWord: String, secondWord: String, c: Int) {
    for (i <- 1 to c) {
      if (i % 3 == 0 && i % 5 == 0) {
        print(firstWord + secondWord)
      }
      else if (i % 3 == 0) {
        print(firstWord)
      }
      else if (i % 5 == 0) {
        print(secondWord)
      }
      else {
        print(i)
      }
      if (i != c) {
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
    else {
    }
  }

  recursion2("H", 4) //needs work, reduces the amount of times it prints the string with each turn

  def recursion3(a: String, b: String, c: Int): String = {
    var output = ""
    logicChecks(a, b, c)

    def logicChecks(firstWord: String, secondWord: String, c: Int) {
      if (c > 0) {
        if (c % 3 == 0 && c % 5 == 0) {
          output = firstWord + secondWord + output
        }
        else if (c % 3 == 0) {
          output = firstWord + output
        }
        else if (c % 5 == 0) {
          output = secondWord + output
        }
        else {
          output = c.toString + output
        }
        if(c!=1){
          output = "," + output
        }
        logicChecks(firstWord, secondWord, c - 1)
      }
    }
    output
  }
  println(recursion3("Fizz", "Buzz", 15))
}