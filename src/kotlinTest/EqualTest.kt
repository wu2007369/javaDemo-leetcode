package kotlinTest

class EqualTest {
}
fun main(args:Array<String>) {
    var str1 = "chaychan"
    var str2 = "ChayChan"
    var str3 = "chaychan"
    println(str1.equals(str2))
    println(str1.equals(str3))

    when(str1){
        str2-> println("==str2")
        str3-> println("==str3")
        else-> println("else")
    }

    when("chaychan"){
        str2-> println("==str2")
        str3-> println("==str3")
        else-> println("else")
    }

    when(""){
        str2-> println("==str2")
        str3-> println("==str3")
        else-> println("else")
    }

    when(null){
        str2-> println("==str2")
        str3-> println("==str3")
        else-> println("else")
    }
}

