package kotlinTest
fun getApplyString():String?{
//    var n:String?=null
    var n:String?="nullString"
    return n?.apply {
        println("n3.lenth=${length}")
    }
}
class ApplyTest {
}

fun main(args:Array<String>) {
    var n1:String?=null
    n1?.apply {
        println(length)
    }

    var n2:String?="null"
    n2?.apply {
        println(length)
    }

    val n3= getApplyString()
    println("n3=${n3}")
}