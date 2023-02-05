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
}

//companion
class MyClass{
    companion object{
        var num:Int = 0
        fun count() = num++
    }
}