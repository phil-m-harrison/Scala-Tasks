object Recursion extends App{
  var total=0
  def numberSum(count:Int, num1:Int): Int ={
    if(count<=num1) {
      total+=count
      numberSum(count+1, num1)
    }
    total
  }
  print(numberSum(1,10))

  var facTotal=1
  def factorial(count:Int, num1:Int): Int ={
    if(num1==0) count
    if(count<=num1) {
      facTotal=facTotal*count
      factorial(count+1, num1)
    }
    facTotal
  }
  print(factorial(1,10))

  var testArray = Array(0,5,12,7,3,6,0,1235,0,135,0,13,6,0,3)
  var zeroes = 0
  def zeroCounter(myArray:Array[Int], element:Int):Int={
    if(element<myArray.length){
      if(myArray(element)==0) zeroes+=1
      zeroCounter(testArray,element+1)
    }
    zeroes
  }
  println(zeroCounter(testArray,0))

  var answer = testArray(0)
  def minElement(myArray:Array[Int], element:Int):Int={
    if(element<myArray.length){
      if(myArray(element)<answer) answer=myArray(element)
      minElement(testArray,element+1)
    }
    answer
  }
  println(minElement(testArray,0))

  def arrayPrinter(myArray:Array[Int], element:Int):Unit={
    if(element<myArray.length){
      println(myArray(element))
      arrayPrinter(myArray, element+1)
    }
  }

  arrayPrinter(testArray,0)
}
