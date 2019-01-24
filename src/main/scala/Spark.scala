import org.apache.spark.{SparkConf, SparkContext, sql}
import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

/*
object Spark {
  def main(args:Array[String]):Unit ={
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf1=new SparkConf().setAppName("main").setMaster("local[*]")
    val sc=new SparkContext(conf1)
    val rdd1 = sc.textFile("C:\\Users\\Admin\\Documents\\clients.txt")

    val sqlContext = new SQLContext(sc)
    val rdd2 = rdd1.filter(x=>{
      val headers = rdd1.first
      x!=headers
    })
    def textSplit(text:String):Tuple5[Int,String,String,Int,String]={
      val record = text.split(",")
      (record(0).toInt,record(1),record(2),record(3).toInt,record(4))
    }
    val rdd3 = rdd2.map(textSplit)
    val rdd4 = rdd3.map(x=>Row(x._1,x._2,x._3,x._4,x._5))
    val schema = StructType(
      StructField("Regno", IntegerType, true) ::
        StructField("Name", StringType, true) ::
        StructField("Subject", StringType, true) ::
        StructField("Marks", IntegerType, true) ::
        StructField("Client", StringType, true) ::
        Nil
    )
    val DF10 = sqlContext.createDataFrame(rdd4,schema)
    DF10.show

    DF10.groupBy("Name").count.show

    DF10.groupBy("Name").agg(sum("Marks") as "Total Marks", mean("Marks") as "Average Marks", max("Marks") as ("Maximum Marks")).show

    DF10.orderBy(DF10("Marks").desc).show
  }
}
*/
object SparkMovies{

  def main(args:Array[String]):Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf1=new SparkConf().setAppName("main").setMaster("local[*]")
    val sc=new SparkContext(conf1)

    val sqlContext = new SQLContext(sc)

    val rdd1 = sc.textFile("C:\\Users\\Admin\\Documents\\movies.txt")

    val rdd2 = rdd1.map(x=>{
      val record = x.split("\t")
      (record(0).toInt,record(1).toInt,record(2).toInt,record(3).toInt)
    })
    val rdd3 = rdd2.map(x=>Row(x._1,x._2,x._3,x._4))

    val schema = StructType(
      StructField("User ID", IntegerType) ::
        StructField("Movie_ID", IntegerType) ::
        StructField("Rating", IntegerType) ::
        StructField("TimeStamp", IntegerType) ::
        Nil
    )
    val DF10 = sqlContext.createDataFrame(rdd3,schema)

    val DF11 = DF10.filter(DF10("Rating")===5).groupBy("Movie_ID").count
 // DF11.show
    val DF12 = DF11.orderBy(DF11("count").desc).first
//print(DF12)
    val rdd10 = sc.textFile("C:\\Users\\Admin\\Documents\\movienames.txt")

    val rdd20 = rdd10.map(x=>{
      val record = x.split("\\|") //wont detect pipe in txt
      (record(0).toInt,record(1))
    })

    val rdd30 = rdd20.map(x=>Row(x._1,x._2))

    val schema2 = StructType(
      StructField("Movie_ID", IntegerType) ::
        StructField("Movie_Name", StringType) ::
        Nil
    )

    val DF20 = sqlContext.createDataFrame(rdd30,schema2)
    val highestRatedFilm = DF20.filter(DF20("Movie_ID")===DF12(0))
    println("----- The film with the most 5 star reviews is -----")
    highestRatedFilm.show

    val DF30 = DF10.groupBy("Movie_ID").count
    val DF31 = DF30.orderBy(DF30("count").desc).first
    val mostPopularFilm = DF20.filter(DF20("Movie_ID")===DF31(0))
    println("----- The film with the most reviews is -----")
    mostPopularFilm.show

    val DF40 = DF10.groupBy("Movie_ID").agg(mean("Rating") as "Average Rating")


    DF10.registerTempTable("MovieRatings")
    DF20.registerTempTable("MovieNames")
    //sqlContext.sql("SELECT Movie_ID, count(*) as Count FROM MovieRatings WHERE Rating=5 group by Movie_ID order by Count desc").show
    sqlContext.sql("SELECT Movie_Name, avg(Rating) as Average_Rating FROM" +
      "(SELECT MovieRatings.Movie_ID, MovieRatings.Rating, MovieNames.Movie_Name FROM " +
      "MovieRatings INNER JOIN MovieNames ON MovieRatings.Movie_ID = MovieNames.Movie_ID) " +
      "group by Movie_Name order by Average_Rating desc").show

    def doubler(A:Double):Double = A*20

    sqlContext.udf.register("sqlDoubler",doubler(_))

    sqlContext.sql("SELECT Movie_Name, sqlDoubler(avg(Rating)) as Average_Percentage FROM" +
      "(SELECT MovieRatings.Movie_ID, MovieRatings.Rating, MovieNames.Movie_Name FROM " +
      "MovieRatings INNER JOIN MovieNames ON MovieRatings.Movie_ID = MovieNames.Movie_ID) " +
      "group by Movie_Name order by Average_Percentage desc").show
  }
}