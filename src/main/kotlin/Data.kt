//data classes
data class Data(var name:String,val id:Int)
//singleton
object Singleton{
   var num:Int = 0
    fun count() = num++
}
//Enum
enum class Id{
    Human,
    Cat,
    Dog
}
enum class Thing(val value:Data){
    Bus(Data("Electric Bus",0)),
    Pen(Data("Cello",1)),
    Box(Data("Big Box",9))
}