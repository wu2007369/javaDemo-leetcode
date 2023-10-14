package kotlinTest

class RunableTest {
}
fun main(args:Array<String>) {
    val runner= Runnable {
        Thread.sleep(2000)
        println("in run end")
    }
    println("in main")
    runner.run()
    println("in main end")
}