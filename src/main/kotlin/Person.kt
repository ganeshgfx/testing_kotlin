import java.math.BigInteger
//interface
interface Sole{
    fun think()
    fun sense(){
        println("Sensing...")
    }
}
class Human() :Sole{
    override fun think() {
        println("Thinking...")
    }

    override fun sense() {
        println("Human Sensing...")
    }

}
//abstract
abstract class Movement{
    abstract var x:Int
    abstract fun move()
}
//inheritance
open class Entity(var isAlive:Boolean) : Movement(){
    open fun checkAliveOrDead() = if(isAlive) "Entity is alive" else "Entity is dead"

    //abstraction
    override var x: Int = 0
    override fun move() {
        x++
        println("Moving... x = $x")
    }
}
class Person(
    val id: String,
    val fName: String,
    val lName: String,
    val designation: String,
    var annualIncome: Double,
    val gender: String, isAlive: Boolean,
) : Entity(isAlive) {

    fun dsp() {
        //templating
        println("my name is $fName $lName")
        println("Monthly income ${annualIncome / 12}")

        //range
        val r = 1..10
        val r1 = 5 downTo 1
        val r2 = 1 until 10 step 2
        val countDown = 10.downTo(1)
        val c = 'a'..'z'
        val isGPresent = 'g' in c

        println(r)
        println(id)
        println(r1)
        println(r2)
        println(countDown)
        println(c)
        println(isGPresent)
        println(countDown)

        //control structure
        val isMale = gender == "male"
        println(isMale)

        println(
            when (designation) {
                "student" -> "Your a student"
                else -> "Invalid"
            }
        )

        //iterators
        for (i in 1..5) {
            print("\t${i}")
        }
        println()

        //naming loops
        outer@ for (i in 1..3) {
            println(i)
            inner@ for (j in 10..13) {
                if (i % 2 == 0) continue@outer
                print("\t${j}")
            }
        }

        println(max(10, 20))
        println(max(15, 25))
        //naming parameter
        val radius = 6.11
        println("Area of circle with $radius is ${radius(PI = 3.14, radius = radius)}")

        //extention
        println("Mr. ".addWithSelf2(fName,lName))

        //infix
        println("Mr. " appendWith fName )

        //tailrec
        //fibo(10000)


    }

    fun getSalary():Double = annualIncome/12

    //expression
    private fun max(a: Int, b: Int): Int = if (a > b) a else b

    //default parameters
    fun radius(radius: Double, PI: Double = 3.14159265359): Double = PI * (radius * radius)

    //method overriding
    override fun checkAliveOrDead():String{
        println(super<Entity>.checkAliveOrDead())
        if(isAlive) return "Person is alive" else return "Person is dead"
    }
}
//extension function
fun Person.haveCar():Boolean = getSalary()>50000
fun String.addWithSelf2(str1:String,str2:String):String = "$this$str1 $str2"
//infix
infix fun String.appendWith(str:String):String = "$this $str"
//tail rec
tailrec fun fibo(n: Int, a: BigInteger = BigInteger("0"), b: BigInteger = BigInteger("1")){
    return if (n > 0) {
        println("\n$a")
        fibo(n - 1, b, a + b)
    }else{}
}

//View model basics
//Coroutines
//Navigation component
//View binding (2 way data binding) and data binding
//Room database
// - Room auto migration
// - Migration with specification
// App dev (suraj sir GitHub)
//MVVM and MVI
//UNIT testing