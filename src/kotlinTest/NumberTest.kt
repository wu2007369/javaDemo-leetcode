//package kotlinTest

    fun main(args:Array<String>) {
        val content:String="32.024498，118.740424"
        val centerList=content.split("，")
        println("Hello world!")
        println(centerList)

        println(centerList?.get(0))
        println(centerList?.get(0)?.toDouble())
/*        val x : Double? =centerList?.get(0)?.toDouble()//纬度
        val y : Double? =centerList?.get(1)?.toDouble()
        println(x)
        println(y)*/

        for (i in 6 downTo 0 step 3) {
            println(i)
        }
        for (i in 6 downTo 0) {
            println(i)
        }
    }

