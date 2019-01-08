object Exercises extends App {
  //first solution using recursion
  def songLyrics(bottleNumber:Int):Unit={
    var lyrics = ""
    if(bottleNumber>1){
      lyrics = s"$bottleNumber bottles of beer on the wall, $bottleNumber bottles of beer.\nTake one down and pass it around, ${bottleNumber-1} bottles of beer on the wall."
      println(lyrics)
      songLyrics(bottleNumber-1)
    }
      //extra if statements for the syntax of last few lines of the song, not needed for basic solution which would yield "0 bottles of beer"
    else if(bottleNumber==1){
      lyrics = s"$bottleNumber bottles of beer on the wall, $bottleNumber bottles of beer.\nTake one down and pass it around, no more bottles of beer on the wall."
      println(lyrics)
      songLyrics(bottleNumber-1)
    }
    else if(bottleNumber==0){
      lyrics = "No more bottles of beer on the wall, no more bottles of beer. \nGo to the store and buy some more, 99 bottles of beer on the wall."
      println(lyrics)
    }
  }
  songLyrics(99)

  //second solution using foreach
  val bottleCount = 99 to 0 by -1
  def songLyrics2(bottleNumber: Int):String = {
    s"$bottleNumber bottles of beer on the wall, $bottleNumber bottles of beer.\nTake one down and pass it around, ${bottleNumber-1} bottles of beer on the wall."
  }
  bottleCount.foreach(numberBottles =>
    if(numberBottles >= 1){
      println(songLyrics2(numberBottles))
    }
    else {
      println("No more bottles of beer on the wall, no more bottles of beer. Go to the store and buy some more, 99 bottles of beer on the wall")
    })

  //manually create array of size 1 million and manually replace elements with different numbers to create duplicates
  var testArray = Array.range(1, 1000000)
  testArray(400)=600

  def arrayCheck(place:Int):Unit={
    for(i<- place until testArray.length if i!= place){
      if(testArray(i)==testArray(place))
        println(s"${i}th location and ${place}th location have repeat values of ${testArray(i)}")
    }
  }
  //still slow using foreach
  testArray.foreach(arrayNumber => arrayCheck(arrayNumber))
}