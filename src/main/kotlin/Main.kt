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
    val v = Data("Value", 1)
    val w = v.copy(id = 2)

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
    var rectangle = Shape.Rectangle(5f, 10f)

    println("Shape is type of ${checkShape(Shape.NotAShape)}")

    //Lambda
    var lmd = Program()
    lmd.add2Num(2, 5)
    lmd.add2Num(2, 9, object : LambdaInterface {
        override fun execute(sum: Int) {
            println(sum)
        }
    })
    //high level function
    val ml: (Int) -> Unit = { i -> println(i) }
    lmd.add2Num(10, 6, ml)
    lmd.add2Num(60, 6, { i ->
        println(i)
    })
    lmd.add2Num(60, 56) { i ->
        println(i)
    }
    lmd.add2Num(100, 200) { x, y -> x + y }
    //it(only for one parameter)
    reverse("Hello", { it.reversed() })

    //with
    var user1 = User()
    with(user1) {
        name = "Erik"
        age = 20
    }
    //apply
    var user2 = User()
    user2.apply {
        name = "John"
        age = 21
    }.getName()

    //arrays (fixed size)
    var arry = Array<Int>(5) { 9 }
    arry[0] = 1
    arry[1] = 2
    arry[2] = 3
    arry[3] = 4
    arry[4] = 5
    for (i in arry) {
        println(i)
    }
    println()
    for (i in 0..arry.size - 1) {
        println(i)
    }
    //list
    //immutable
    var list = listOf<String>("Yogi", "Manmohan", "Vajpai")
    for (v in list) {
        println(v)
    }
    println()
    //mutable
    var list2 = mutableListOf<String>("Raj", "Ajay", "Raju")
    list2.add("Ketan")
    for (v in list2) {
        println(v)
    }
    //map
    //immutable
    var map = mapOf<Char, String>('c' to "cat", 'd' to "dog")
    println()
    for (key in map.keys) {
        println("$key => ${map.get(key)}")
    }
    //mutable
    var hMap = hashMapOf<String, String>()
    hMap.put("A", "ABC")
    hMap.put("X", "XYZ")
    println(hMap)
//Set
// immutable
    val set = setOf<Int>(1, 2, 3, 3, 6, 6, 7, 8, 9, 0)
    println(set)
// mutable
    var hSet = mutableSetOf<Int>(1, 2, 3, 3, 6, 6, 7, 8, 9, 0)
    hSet.add(1)
    hSet.add(10)
    hSet.add(10)
    println(hSet)

    //filter
    var nums  = listOf(1,2,6,7,8,3,0,1)
    println(nums)
    val sNums = nums.filter { v->v<5 }
    println(sNums)

}

fun checkShape(shape: Shape) =
    when (shape) {
        is Shape.Circle -> "Circle"
        is Shape.Square -> "Square"
        is Shape.Rectangle -> "Square"
        Shape.NotAShape -> "Not a Shape"
        else -> "Invalid Shape"
    }

//companion
class MyClass {
    companion object {
        var num: Int = 0
        fun count() = num++
    }
}

//Lambda
class Program {
    //simple
    fun add2Num(a: Int, b: Int) {
        val sum = a + b
        println(sum)
    }

    //interface
    fun add2Num(a: Int, b: Int, action: LambdaInterface) {
        val sum = a + b
        action.execute(sum)
    }

    //lambda
    fun add2Num(a: Int, b: Int, action: (Int) -> Unit) {
        val sum = a + b
        action(sum)
    }

    fun add2Num(a: Int, b: Int, action: (Int, Int) -> Int) {
        val result = action(a, b)
        println(result)
    }
}

interface LambdaInterface {
    fun execute(sum: Int)
}

fun reverse(str: String, func: (String) -> String) {
    var result = func(str)
    println(result)
}
