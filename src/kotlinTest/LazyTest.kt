package kotlinTest

class LazyTest {
    val str by lazy {
        println("Init lazy")
        "Hello World"
    }
}

fun main(args:Array<String>) {
    val bean = LazyTest()
    println("Init Bean")
    println(bean.str)
    println(bean.str)
}