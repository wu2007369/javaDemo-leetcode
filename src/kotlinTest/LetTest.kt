package kotlinTest

class LetTest {
}

fun main(args:Array<String>) {
    var a:String?="csa"
    a?.let {
        println("null")
        null
    }?: println("cascascascascas")
}