package kotlinTest

import java.text.SimpleDateFormat
import java.util.*

class CalendarTest {
}

fun main(args:Array<String>) {
    // 使用默认时区和语言环境获得一个日历
    val cal = Calendar.getInstance()
    showCalender(cal)

    cal.clear()
    cal.set(Calendar.YEAR, 2021)
    cal.set(Calendar.MONTH, Calendar.APRIL)
    showCalender(cal)
    println(getAllDay(7))
}

fun  getAllDay(month:Int):List<String> {
    var list =  ArrayList<String>()
    val cal = Calendar.getInstance()
    cal.clear()
    cal.set(Calendar.MONTH, month-1)
    cal.set(Calendar.DAY_OF_MONTH, 1);
    var maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    val sdf =  SimpleDateFormat("yyyy-MM-dd");
    list=addHead(list,cal)

    cal.clear()
    cal.set(Calendar.MONTH, month-1)
    cal.set(Calendar.DAY_OF_MONTH, 1)
    for ( i in 0 until maxDate) {
        val d = cal.time
        val date = sdf.format(d)
        list.add(date+ getWeek(cal))
        cal.add(Calendar.DAY_OF_MONTH, 1)
    }

    list=addTail(list,cal)

    return list
}



fun showCalender(cal: Calendar) {
    // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
    println("年:" + cal.get(Calendar.YEAR))
    println("月:" + (cal.get(Calendar.MONTH) + 1))
    println("日:" + cal.get(Calendar.DAY_OF_MONTH))
/*    println("时:" + cal.get(Calendar.HOUR_OF_DAY))
    println("分:" + cal.get(Calendar.MINUTE))
    println("秒:" + cal.get(Calendar.SECOND))*/

    println(cal.time)
//    println("周:$week")
}

fun getWeek(cal: Calendar):String {
    val week=when(cal.get(Calendar.DAY_OF_WEEK)){
        1->"天"
        2->"一"
        3->"二"
        4->"三"
        5->"四"
        6->"五"
        7->"六"
        else->""
    }
    return "周:$week"
}

fun addHead(list: ArrayList<String>, cal: Calendar): ArrayList<String> {
    val sdf =  SimpleDateFormat("yyyy-MM-dd")

    return if (cal.get(Calendar.DAY_OF_WEEK)==2){
        list
    }else{
        while (  cal.get(Calendar.DAY_OF_WEEK) !=  2 ) {
            cal.add(Calendar.DAY_OF_MONTH, -1)
            val d = cal.time
            val date = sdf.format(d)
            list.add(0,date+ getWeek(cal))
        }
        cal.add(Calendar.DAY_OF_MONTH, -1)
        val d = cal.time
        val date = sdf.format(d)
        list.add(0,date+ getWeek(cal))
        list
    }
}

fun addTail(list: ArrayList<String>, cal: Calendar): ArrayList<String> {
    val sdf =  SimpleDateFormat("yyyy-MM-dd")

    return if (cal.get(Calendar.DAY_OF_WEEK)==1){
        list
    }else{
        while ( cal.get(Calendar.DAY_OF_WEEK) !=  1 ) {
            val d = cal.time
            val date = sdf.format(d)
            list.add(date+ getWeek(cal))
            cal.add(Calendar.DAY_OF_MONTH, 1)
        }
        val d = cal.time
        val date = sdf.format(d)
        list.add(date+ getWeek(cal))
        list
    }
}