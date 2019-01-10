import scala.io.Source
import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object Keyboard extends App {

  println("Enter number of broken keyboards")
  val stringsArray = new ArrayBuffer[String]()

  for (i <- 0 until readInt){
    println(s"Type the available keys for keyboard number $i")
    stringsArray.append(readLine)
  }

  val dictionary = Source.fromFile("C:\\Users\\Admin\\Desktop\\Scala\\Material\\enable1.txt").getLines.toArray
  var matchCount = 0
  var validCharCount = 0
  var highCount=0
  var longestWord = ""
  var validWord = 0

  for (whichWord <- 0 until stringsArray.length) {
    for (dictWordNum <- 0 until dictionary.length) {
      for (dictCharLocation <- 0 until dictionary(dictWordNum).length) {
        for(mycharLocation <- 0 until stringsArray(whichWord).length){
          if (dictionary(dictWordNum).substring(dictCharLocation, dictCharLocation + 1) == stringsArray(whichWord).substring(mycharLocation, mycharLocation + 1)) matchCount += 1
        }
        if(matchCount>dictCharLocation) validCharCount+=1
      }
      if (matchCount == dictionary(dictWordNum).length && matchCount>=highCount && validCharCount>=dictionary(dictWordNum).length){
        highCount=matchCount
        longestWord = dictionary(dictWordNum)
      }
      matchCount=0
      validCharCount=0
      validWord=0
    }
    println(s"The longest word found from ${stringsArray(whichWord)} = $longestWord")
    highCount=0
  }
}