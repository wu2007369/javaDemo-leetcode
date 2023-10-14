package kotlinTest

class ListTest (var content:String?=null){
}

fun main(args: Array<String>) {
    val list1: MutableList<ListTest> = mutableListOf(ListTest("abcde"), ListTest("aaaaa"), ListTest("bbbbb"))
    val list2: MutableList<ListTest> = mutableListOf()
    list2.add(list1[1])
    list2.add(list1[2])
    list2.forEach {
        println(it.content)
    }
    list2[1].content="ccccc"
    list2.forEach {
        println(it.content)
    }
    list1.forEach {
        println(it.content)
    }
}