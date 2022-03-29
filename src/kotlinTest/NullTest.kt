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
    println(n3?.length?:"total null")

    var n4:String?="与n3相对比的例子"
    println(n4?.length?:"total null")
    println(n4?.let { null }?:"total null,这证明，let的返回值为空，有可能导致?:后的继续执行")

    var n5 :String?=null
    n5=n5?:"n5"
//    n5=n5?:"n5 again"
    println("n5 value =${n5}")


    //    val list1:List<Int>?=null
//    val list1:List<Int>?= listOf()
    val list1:List<Int>?= listOf(1,2,3)
    println("isNullOrEmpty="+list1.isNullOrEmpty())
    println("isNotEmpty="+list1?.isNotEmpty())
    println("isNotEmpty="+(list1?.isNotEmpty()==true))
    println("isEmpty="+list1?.isEmpty())
    println("isEmpty="+(list1?.isEmpty()==true))
    println("isNull="+(list1==null))
}