//Data classes
data class Data(var name:String,val id:Int)
//Singleton
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
//Sealed
sealed class Shape{
    class Circle(var radius:Float):Shape()
    class Square(var side:Float):Shape()
    class Rectangle(var height:Float, var width:Float):Shape()
    object NotAShape:Shape()
}