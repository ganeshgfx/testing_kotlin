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
}

//companion
class MyClass{
    companion object{
        var num:Int = 0
        fun count() = num++
    }
}