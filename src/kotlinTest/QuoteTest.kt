package kotlinTest

class QuoteTest {
    val content1="caljcmklasjckls"
    var content2="222222222222"
    override fun toString(): String {
        return content1+";"+content2
    }
}

fun main() {
    var quote1=QuoteTest()
    var quote2=quote1
    quote2.content2="test"
    println(quote2)
    println(quote1)

}