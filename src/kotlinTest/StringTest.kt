package kotlinTest

import java.util.regex.Pattern

class StringTest {
}

fun main(args:Array<String>) {
    val s="aswdsadasdsad"
    println(s.replace("aswd","1111"))
    println(s)

    println(isAllChinses("csildjclosdjclsdjml"))
    println(isAllChinses("说出口都扣"))
    println(isAllChinses("说出口都扣cascko;asko;axcsko;kco哦才开始打locksoak从； "))
}


//检查是否存在汉字
fun  checkHaveChinses( name:String):Boolean
{
    val  p = Pattern.compile("[\u4e00-\u9fa5]")
    val  m = p.matcher(name)
    if (m.find()) {
        return true
    }
    return false
}

fun  isAllChinses( name:String):Boolean
{
    name.toCharArray().forEach { c: Char ->
        val num=c.toInt()
        if(!(num in 19968..40868)) {
            return false
        }
    }
    return true

}
