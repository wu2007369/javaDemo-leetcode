package kotlinTest

class SequenceTest (var from: String){
    val test= println("test")

        /*属性from*/
        //已经在主构造函数中声明 private var from: String = ""

        /*次构造方法*/
        constructor(from1: String, name: String) : this(from1) {
            println("constructor, from:$from1")
        }

        companion object {
            val instance = SequenceTest("companion")

            /*伴生对象中的初始化代码*/
            init {
                println("companion init 1")
            }

            init {
                println("companion init 2")
            }

            /* 伴生对象中不允许有构造函数
            constructor() {
                println("companion constructor")
            } */
        }

        /*初始化代码块*/
        init {
            println("init 2, from:${from}")
        }

        /*初始化代码块*/
        init {
            println("init 1, from:${from}")
        }

}

fun main(args: Array<String>) {
    println("调用次构造方法:")
    SequenceTest("main1", "name1")

    println("调用主构造方法:")
    SequenceTest("main2")
}