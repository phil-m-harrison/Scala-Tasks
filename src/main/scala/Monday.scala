Object extends App{

}
println("Hello world")

var a = "hello world"
println(a)
def helloWorld(a:String){
  println(a)
}
helloWorld("Hello world")

def helloWorld2():String={
  var a = "hello world"
  return a
}

println(helloWorld2)


def strings(a:String, b:Int):String={
  var c = a.substring(a.length-b,a.length)
  return c
}

println(strings("hello", 3))

def strings2(a:String,b:String,c:Char,d:Char):String={
  var comb = a+b
  var myreturn = ""

  for(i<- 0 until comb.length){
    if(comb.substring(i,i+1)==c.toString){
      myreturn = myreturn + d

    }
    else{
      myreturn+=comb.substring(i,i+1)
    }

  }
  return myreturn
}

println(strings2("Ha","llo",'a','e'))

def add(a:Int, b:Int, c:Boolean):Int={
  if(a==0||b==0){
    if(b>a){
      return b
    }
    else{
      return a
    }
  }
  else if(c){
    return a+b
  }
  else{
    return a*b
  }
}
println(add(0,3,3!=3))

def iteration(a:String,b:Int){
  for(i<- 1 to b){
    println(a)
  }
}

iteration("H",4)



def iteration2(a:String,b:Int){
  for(i<- 1 to b){
    for(i<- 1 to b){
      print(a)
    }
    print("\n")
  }
}

iteration2("H",4)

def iteration3(a:String,b:String,c:Int){
  for(i<- 1 to c){
    if(i%3==0 && i%5==0){
      print(a+b)
    }
    else if(i%3==0){
      print(a)
    }
    else if(i%5==0){
      print(b)
    }
    else{
      print(i)
    }
    if(i==c){

    }
    else{
      print(",")
    }
  }
}
iteration3("Fizz","Buzz",15)


def recursion(a:String,b:Int){
  if(b>0){
    println(a)
    recursion(a,b-1)
  }
  else{
    println(a)
  }

}

recursion("H",4)

def recursion2(a:String,b:Int){
  if(b>0){
    def nestedrecursion(c:String,d:Int){
      if(d>0){
        print(c)
        //nestedrecursion(c,d-1)
      }
      else{
        println("")
        nestedrecursion(a,b)
      }
    }
    nestedrecursion(a,b)
    recursion2(a,b-1)

  }
  else{
  }
}

recursion2("H",4)
