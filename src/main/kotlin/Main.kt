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

}
