object CreditCard extends App{
//  def idChecker(id:Long):Boolean={
//    var sumCheck = 0
//    for(i<- id.toString.length-1 to 0 by -1){
//      if((id.toString.length+i)%2==0){
//        var adder = id.toString.substring(i,i+1)
//        var doubleCheck = 2*adder.toInt
//        if(doubleCheck>9) sumCheck += doubleCheck.toString.substring(0,1).toInt + doubleCheck.toString.substring(1,2).toInt
//        else sumCheck += doubleCheck
//      }
//      else sumCheck+=id.toString.substring(i,i+1).toInt
//    }
//    sumCheck%10==0
//  }
//  var idTest = 49927398716L
//
  def idChanger(id:Long)={
    if(idChecker(id)) println(id)
    else{
        for(i<- 1L to 9L){
          if(idChecker((id.toString+i.toString).toLong)) println(id.toString+i.toString)
        }
    }
  }
  idChanger(49927398718L)

  def idChecker(id:Long):Boolean={
    var changingID = id
    var returnval = 0
    for(i<- id.toString.length to 0 by -2){
      var remainder = changingID%10
      returnval+=remainder.toInt
      changingID = changingID/100
    }
    changingID=id
    for(i<- (id.toString.length-1) to 0 by -2){
      var remainder = (changingID/10)%10
      var changingIDremainder = 2*remainder.toInt
      if(changingIDremainder>9) returnval+=changingIDremainder/10 + changingIDremainder%10
      else returnval+= changingIDremainder
      changingID = changingID /100
    }
    returnval%10==0
  }
}