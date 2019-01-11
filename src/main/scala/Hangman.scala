import scala.io.Source
import scala.io.StdIn._
import scala.util.Random

object Hangman extends App {

    var incorrectCount=0
    def startGame():Any= {
      incorrectCount = 0
      val words = Source.fromFile("C:\\Users\\Admin\\Desktop\\Scala\\Material\\words_alpha.txt").getLines.toList
      val mediumWords = words.filter(_.length<8).filter(_.length >5)
      val easyWords = words.filter(_.length < 6)
      println("Welcome to hangman!")
      println("Please select the difficulty level, Easy(1), Medium(2), or Hard(3)")
      try {
        readInt match {
          case 1 => playWordGen(easyWords)
          case 2 => playWordGen(mediumWords)
          case 3 => playWordGen(words)
          case _ => {
            println("Try again")
            startGame()
            var numberError = new NumberFormatException
            throw numberError
          }
        }
      }
      catch{
        case a:NumberFormatException => {
          println("Try again")
          startGame()
        }
      }
    }
    def playWordGen(words:List[String]):Any={

      val playWord = words(Random.nextInt(words.length-1))
      println(s"word is $playWord")
      //val playWord = words(Random.nextInt(words.length))
      val outputArray = new Array[String](playWord.length)
      for(i<-0 until playWord.length){
        outputArray(i)="_"
      }
      playerGuesser(playWord, outputArray)
    }

    def playerGuesser(playWord:String, outputArray:Array[String]): Any ={
      println("\nPlease guess a letter")
      val guess = readLine
      var correctCount =0
      for(i<-0 until playWord.length){
        if(playWord.substring(i,i+1)==guess) correctCount+=1
      }
      if(correctCount==0){
        println("Incorrect guess!")
        incorrectCount+=1
        hangmanPrinter(playWord, incorrectCount, guess, outputArray)
        playerGuesser(playWord, outputArray)
      }
      else{
        println("Correct guess!")
        hangmanPrinter(playWord,  incorrectCount, guess, outputArray)
        playerGuesser(playWord, outputArray)
      }
      for(i<- 0 until playWord.length){
        if(playWord.substring(i,i+1)==guess) outputArray(i)=guess
        print(outputArray(i)+" ")
      }
      if(outputArray.count(_ =="_")==0){
        println("\nYou win!")
        startGame()
      }
      playerGuesser(playWord, outputArray)
    }

    def hangmanPrinter(playWord:String, incorrectCount:Int, letterGuess:String, outputArray:Array[String])={
      incorrectCount match{
        case 0 => println("6 incorrect guesses remaining")
        case 1 => println("__________")
        case 2 => println("|\n|\n|\n|\n|\n|\n__________")
        case 3 => println("_____\n|\n|\n|\n|\n|\n|\n__________")
        case 4 => println("_____\n|    |\n|\n|\n|\n|\n|\n__________")
        case 5 => println("_____\n|    |\n|    o\n|   \\|/\n|\n|\n|\n__________")
        case 6 => {
          println("_____\n|    |\n|    o\n|   \\|/ \n|    |\n|    /\\ \n|\n__________")
          println(s"Game over! The word was $playWord")
          startGame()
        }
      }
    }
    startGame()
}
