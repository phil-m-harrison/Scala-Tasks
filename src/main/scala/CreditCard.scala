object CreditCard extends App{
  def idChanger(id:Long)={
    if(idChecker(id)) println(id)
    else{
        for(i<- 0L to 9L){
          if(idChecker(id+i)) println(id+i)
        }
    }
  }
  idChanger(9090909090L)

  def idChecker(id:Long):Boolean={
    var changingID = id
    var returnval = 0
    for(i<- 0 to id.toString.length/2){
      returnval+=(changingID%10).toInt
      changingID = changingID/100
    }
    changingID=id
    for(i<- 0 to (id.toString.length-1)/2){
      var doubledRemainder = 2*((changingID/10)%10).toInt
      if(doubledRemainder>9) returnval+=doubledRemainder/10 + doubledRemainder%10
      else returnval+= doubledRemainder
      changingID = changingID /100
    }
    returnval%10==0
  }
}