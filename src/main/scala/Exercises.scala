object Exercises extends App {
  //first solution using recursion
  def songLyrics(bottleNumber:Int):Unit={
    if(bottleNumber>1){
      println(s"$bottleNumber bottles of beer on the wall, $bottleNumber bottles of beer.\nTake one down and pass it around, ${bottleNumber-1} bottles of beer on the wall.")
      songLyrics(bottleNumber-1)
    }
      //extra if statements for the syntax of last few lines of the song, not needed for basic solution which would yield "0 bottles of beer"
    else if(bottleNumber==1){
      println(s"$bottleNumber bottles of beer on the wall, $bottleNumber bottles of beer.\nTake one down and pass it around, no more bottles of beer on the wall.")
      songLyrics(bottleNumber-1)
    }
    else if(bottleNumber==0) println("No more bottles of beer on the wall, no more bottles of beer. \nGo to the store and buy some more, 99 bottles of beer on the wall.")
  }
  songLyrics(99)

  //second solution using foreach
  val bottleCount = 99 to 0 by -1
  def songLyrics2(bottleNumber: Int):String = s"$bottleNumber bottles of beer on the wall, $bottleNumber bottles of beer.\nTake one down and pass it around, ${bottleNumber-1} bottles of beer on the wall."
  bottleCount.foreach(numberBottles =>
    if(numberBottles >= 1)println(songLyrics2(numberBottles))
    else println("No more bottles of beer on the wall, no more bottles of beer. Go to the store and buy some more, 99 bottles of beer on the wall"))

  //manually create array of size 1 million and manually replace elements with different numbers to create duplicates
  var testArray = Array.range(1, 1000000)
  testArray(1000)=2000
  //this method assumes the numbers could be random ordered eg 4,2146,45,93,32476

  def arrayCheck(place:Int):Unit={
    for(i<- place until testArray.length if i!= place){
      if(testArray(i)==testArray(place)) println(s"${i}th location and ${place}th location have repeat values of ${testArray(i)}")
    }
  }
  //still slow using foreach

  testArray.foreach(arrayNumber => arrayCheck(arrayNumber))

  //this method uses API to sort the potentially random array into the form 1,2,3,4,5,6,7,8,9,10 etc to make the search for repeats much quicker

  val sortedArray = testArray.sorted
  def arrayCheck2(size:Int):Unit={
    for(i<- 0 until size-1){
      if(sortedArray(i)==sortedArray(i+1)) println(s"There is a duplicate of value ${sortedArray(i)}")
    }
  }
  arrayCheck2(testArray.length)
}