package kotlinTest

import kotlinx.coroutines.*

class CourotinTest {
}

fun main(args:Array<String>) {
    testCoroutineScope2()
}

private fun testCoroutineScope2() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->println("exceptionHandler ${coroutineContext[CoroutineName]} $throwable")
    }
    println("satrt")
    GlobalScope.launch(Dispatchers.Default + CoroutineName("scope1") + exceptionHandler) {
        println("scope --------- 1")
        launch(CoroutineName("scope2") + exceptionHandler) {
            println("scope --------- 2")
            throw NullPointerException("􏱹􏵛􏸥")
            println("scope --------- 3")
        }
        val scope3 = launch(CoroutineName("scope3") + exceptionHandler) {
            println("scope --------- 4")
            delay(2000)
            println("scope  --------- 5")
        }
        scope3.join()
        println("scope --------- 6")
    }
}
