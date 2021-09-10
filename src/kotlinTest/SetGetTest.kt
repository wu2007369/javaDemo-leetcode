package kotlinTest

class SetGetTest {
    var num:Int=0
    get() =field+1
    set(value) {
        field = value+99
        println("realvalue="+(value+99))
    }
}

fun main(args:Array<String>) {
    val a=SetGetTest()
    println(a.num)
    println(a.num)
    println(a.num)
    a.num=100
    println(a.num)
}