import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object MorseCode extends App {
  val morseLetters = List(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
  val alphabet = ('a' to 'z').toList
  println("Would you like to convert morse code to English(1) or English to morse code(2)?")
  readInt match{
    case 1 => morseToString
    case 2 => stringsToMorse
  }

  def stringsToMorse()={
    println("Please enter a word to translate")
    var input = readLine
    var output = ""
    for(i<-0 until input.length){
      alphabet.foreach(element => {
        if(input.substring(i,i+1)==element.toString) output+=morseLetters(alphabet.indexOf(element))+" "
      })
      if(i>0 && input.substring(i-1,i)!=" " && input.substring(i,i+1)==" " ) output+=" / "
    }
    print(output)
  }

  def morseToString()={
    println("Enter input")
    var morseInput = readLine
    var newArray = morseInput.split(" ")
    newArray.foreach(element => {
      morseLetters.foreach(morseElement => if(morseElement==element) print(alphabet(morseLetters.indexOf(morseElement))))
    })
  }
}