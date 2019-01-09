object Keyboard extends App {

  import scala.io.Source

  println("Enter number of character strings to read")
  val wordAmount = scala.io.StdIn.readInt()
  var stringsArray = new Array[String](wordAmount)
  println("Type that many strings")
  for (i <- 0 until wordAmount) {
    stringsArray(i) = scala.io.StdIn.readLine()
  }

  val dictionary = Source.fromFile("C:\\Users\\Admin\\Desktop\\Scala\\Material\\enable1.txt").getLines.toArray
  var matchCount = 0
  var validWord = 0
  var highCount=0
  var longestWord = ""
  for (whichWord <- 0 until wordAmount) {
    for (dictWordNum <- 0 until dictionary.length) {
      for (dictCharLocation <- 0 until dictionary(dictWordNum).length) {
        for(mycharLocation <- 0 until stringsArray(whichWord).length){
          if (dictionary(dictWordNum).substring(dictCharLocation, dictCharLocation + 1) == stringsArray(whichWord).substring(mycharLocation, mycharLocation + 1)) matchCount += 1
        }
        if(matchCount==0 || ){
          validWord+=1
        }
      }
      if (matchCount == dictionary(dictWordNum).length && matchCount>=highCount && validWord==0) {
          highCount=matchCount
          longestWord = dictionary(dictWordNum)
      }
      matchCount=0
      validWord=0
    }
    println(s"The longest word found from ${stringsArray(whichWord)} = $longestWord")
    highCount=0
  }
}
