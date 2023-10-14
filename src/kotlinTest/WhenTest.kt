package kotlinTest

class WhenTest {
}
enum class TEST1(val value:String){
    A("Abcde"),B("fGhiJ"),C("klMno");

}
fun main(args:Array<String>) {
    val astring="Abcde"
    val bstring="fGhiJ"
    val cstring="klMno"
    when(astring){
        TEST1.A.value-> println("1")
        TEST1.B.value-> println("2")
        TEST1.C.value-> println("3")
    }
    when(bstring){
        TEST1.A.value-> println("1")
        TEST1.B.value-> println("2")
        TEST1.C.value-> println("3")
    }
    when(cstring){
        TEST1.A.value-> println("1")
        TEST1.B.value-> println("2")
        TEST1.C.value-> println("3")
    }
}