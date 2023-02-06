fun main() {

    val obj = Person(
        "ganesh123",
        "Ganesh",
        "Ghutiya",
        "student",
        12000.0,
        "male",
        isAlive = false
    )

    //println("Have Car : ${obj.haveCar()}")
    obj.dsp()
    println(obj.checkAliveOrDead())
    obj.move()

    //data
    val v = Data("Value",1)
    val w = v.copy(id=2)

    println("$v - $w")

    //companion
    println("companion -> ${MyClass.count()}")

    //Enum
    println("${Id.Cat} | ${Id.Cat.ordinal} | ${Id.Cat.declaringClass}")
    Id.values().forEach { println(it) }
    Thing.values().forEach { println("$it -> ${it.value}") }

    //Sealed
    var circle = Shape.Circle(1.6f)
    var square = Shape.Square(10f)
    var rectangle = Shape.Rectangle(5f,10f)

    println("Shape is type of ${checkShape(Shape.NotAShape)}")

    //Lambda
    var lmd = Program()
    lmd.add2Num(2,5)
    lmd.add2Num(2,9,object:LambdaInterface{
        override fun execute(sum: Int) {
            println(sum)
        }
    })
    //high level function
    val ml:(Int)->Unit = {i-> println(i) }
    lmd.add2Num(10,6,ml)
    lmd.add2Num(60,6,{
            i-> println(i)
    })
    lmd.add2Num(60,56) {
            i -> println(i)
    }
    lmd.add2Num(100,200) { x, y -> x + y }
    //it(only for one parameter)
    reverse("Hello",{it.reversed()})

    //with
    var user1 = User()
    with(user1){
        name = "Erik"
        age = 20
    }
    //apply
    var user2 = User()
   user2.apply{
        name = "John"
        age = 21
    }.getName()

}
fun checkShape(shape:Shape) =
    when(shape){
        is Shape.Circle -> "Circle"
        is Shape.Square -> "Square"
        is Shape.Rectangle -> "Square"
        Shape.NotAShape -> "Not a Shape"
        else -> "Invalid Shape"
    }
//companion
class MyClass{
    companion object{
        var num:Int = 0
        fun count() = num++
    }
}

//Lambda
class Program {
    //simple
    fun add2Num(a:Int,b:Int){
        val sum = a+b
        println(sum)
    }
    //interface
    fun add2Num(a:Int,b:Int,action:LambdaInterface){
        val sum = a+b
        action.execute(sum)
    }
    //lambda
    fun add2Num(a:Int,b:Int,action:(Int)->Unit){
        val sum = a+b
        action(sum)
    }
    fun add2Num(a:Int,b:Int,action:(Int,Int)->Int){
        val result = action(a,b)
        println(result)
    }
}
interface LambdaInterface{
    fun execute(sum:Int)
}
fun reverse(str:String,func:(String)->String){
    var result = func(str)
    println(result)
}
