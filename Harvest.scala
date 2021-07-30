import scala.io.StdIn._
import scala.util.Random

class HarvestStatProblem{
    var harvest = Array.ofDim[Int](4,7)
    var min:Int = 0
    var max:Int = 0
    var maxWeek = 0
    var maxDay = 0
    var minWeek = 0
    var minDay = 0
    var total = 0
    var count = 0
    var avg = 0
    var count1 = new Array[Int](5) //For date of min
    var count2 = new Array[Int](5) // For date of max
    var week= Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" )

    def printVal(){
      for(i<-0 to 6)
      {
        print(week(i)+" ")
      }
      println()

      for(i<- 0 to 3){
          for(j<- 0 to 6){
             print(harvest(i)(j)+" ")
          }
          println()
       }
    }
  
    def MinVal(){
        min = harvest(0)(0)
        for(i<- 0 to 3){
           for(j<- 0 to 6){
               if(min >= harvest(i)(j)){
                   min = harvest(i)(j)
                   minDay = j
                   minWeek = i
               }
           }
        }
        println("Minimum harvest of the month is "+min+" and it occurs in the "+minWeek+"th week and it is "+week(minDay))

    }
    
    def MaxVal(){
        max = harvest(0)(0)
        for(i<- 0 to 3){
            for(j<- 0 to 6){
                if(max <= harvest(i)(j)){
                    max = harvest(i)(j)
                    maxDay = j
                    maxWeek = i
                }
            }
        }
        println("Maximum harvest of the month is "+max+" and it occurs in the "+maxWeek+ "th week and it is "+week(maxDay))

    }

    def AvgVal(){
          println("Weekly average")
          for(i<- 0 to 3){
              for(j<- 0 to 6){
                  total += harvest(i)(j)            
                  count = count +1 
              }
              avg = total / count
              print("Week"+(i+1)+ " average = "+avg)
          }
    }
    
    def inputVal(){
         for(i<- 0 to 3){
             for(j<- 0 to 6){
                  harvest(i)(j)=readInt()
             }
         }

    }
}


object MainObject{
    def main(args:Array[String]){
        var a = new HarvestStatProblem ()
        a.inputVal()
        a.printVal()
        a.MinVal()
        a.MaxVal()
        a.AvgVal()
    }
}
