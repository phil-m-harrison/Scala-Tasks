import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object MorseCode extends App {
  val morseLetters = List(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
  val alphabet = ('a' to 'z').toList
  println("Please enter a word to translate")
  var input = readLine
  var output = ""
  for(i<- 0 until input.length){
    for(j<- 0 until alphabet.length){
      if(input.substring(i,i+1)==alphabet(j).toString) output+=morseLetters(j)+" "
    }
    if(i>0 && input.substring(i-1,i)!=" " && input.substring(i,i+1)==" " ) output+=" / "
  }
  print(output)
}