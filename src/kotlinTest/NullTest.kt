package kotlinTest

class NullTest {


}

fun main(args:Array<String>) {
    var n=null
    println(n)
    var n2=""
    println(n2)
    println(n?:"2")
    var n3:String?=null
    println(n3?.length)
}