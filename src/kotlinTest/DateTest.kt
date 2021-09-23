package kotlinTest

import java.text.SimpleDateFormat
import java.util.*

fun main(args:Array<String>) {
    val simpleDate = SimpleDateFormat("HH:MM", Locale.CHINA)
    val nowDate = Date()
    val startDate = simpleDate.parse("7:00")
    val endDate = simpleDate.parse("19:43")
    val nowTime = simpleDate.format(nowDate)
    val startTime = simpleDate.format(startDate)
    val endTime = simpleDate.format(endDate)
    System.out.println("startTime:"+startTime)
    System.out.println("endTime:"+endTime)
    System.out.println("nowTime:"+nowTime)
    if (nowDate.time<endDate.time&&nowDate.time>startDate.time) {
        System.out.println("在时间中:")
        return
    }

    if (nowTime<startTime&&nowTime>endTime) {
        System.out.println("在时间中:")
        return
    }
    System.out.println("bu在时间中")
}