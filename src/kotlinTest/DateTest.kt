package kotlinTest

import java.text.SimpleDateFormat
import java.util.*

fun main(args:Array<String>) {
    val nowDate = Date()
    val simpleDate = SimpleDateFormat("HH:MM", Locale.CHINA)
    val nowTime = simpleDate.format(nowDate)
    val startTime = simpleDate.format(simpleDate.parse("7:00"))
    val endTime = simpleDate.format(simpleDate.parse("9:43"))
    System.out.println("startTime:"+startTime)
    System.out.println("endTime:"+endTime)
    System.out.println("nowTime:"+nowTime)
    if (nowTime<endTime&&nowTime>startTime) {
        System.out.println("在时间中:")
        return
    }
    System.out.println("bu在时间中")
}