package kotlinTest

class ListTest {
}

fun main(args:Array<String>) {
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