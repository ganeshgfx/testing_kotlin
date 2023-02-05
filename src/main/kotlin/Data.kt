//data classes
data class Data(var name:String,val id:Int)
//singleton
object Singleton{
   var num:Int = 0
    fun count() = num++
}