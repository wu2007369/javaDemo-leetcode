package javaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {

    public static void main(String []args){
        String content= "";
        try {
            content = getGreetingByTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }

    /**
     * 招呼语,根据国际惯例划分为6个时间，分别为
     * 0-6点 凌晨好，
     * 6-11点 上午好，
     * 11-13点 中午好，
     * 13-16点 下午好，
     * 16-18点 傍晚好，
     * 18-24点 晚上好。
     *
     * @return
     */
    public static String getGreetingByTime() throws ParseException {
//        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:MM", Locale.CHINA);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");

        String now=simpleFormat.format(new Date());
        Date nowDate=simpleFormat.parse(now);
        Date nowDate2=simpleFormat.parse("10:10");
        Date zeroDate = simpleFormat.parse("0:00");
        Date sixDate = simpleFormat.parse("6:00");
        Date elevenDate = simpleFormat.parse("11:00");
        Date thirteenDate = simpleFormat.parse("13:00");
        Date sixTeenDate = simpleFormat.parse("16:00");
        Date eighteenDate = simpleFormat.parse("18:00");
        Date endDate = simpleFormat.parse("24:00");

        Calendar nowTime = Calendar.getInstance();
        Calendar zeroTime = Calendar.getInstance();
        Calendar sixTime = Calendar.getInstance();
        Calendar elevenTime = Calendar.getInstance();
        Calendar thirteenTime = Calendar.getInstance();
        Calendar sixTeenTime = Calendar.getInstance();
        Calendar eighTeenTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();

        nowTime.setTime(nowDate);
        zeroTime.setTime(zeroDate);
        sixTime.setTime(sixDate);
        elevenTime.setTime(elevenDate);
        thirteenTime.setTime(thirteenDate);
        sixTeenTime.setTime(sixTeenDate);
        eighTeenTime.setTime(eighteenDate);
        endTime.setTime(endDate);

        if (nowTime.before(sixTime)) {
            if (nowTime.after(zeroTime)) {
                return "凌晨好";
            }
        } else if (nowTime.before(elevenTime)) {
            return "上午好";
        } else if (nowTime.before(thirteenTime)) {
            return "中午好";
        } else if (nowTime.before(sixTeenTime)) {
            return "下午好";
        } else if (nowTime.before(eighTeenTime)) {
            return "傍晚好";
        } else if (nowTime.before(endTime)) {
            return "晚上好";
        }
        return "";

    }
}
