package javaTest;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String []args){
        System.out.println(""+(Float.valueOf("100")-Float.valueOf("0.5")));
        System.out.println(""+(Float.valueOf("100")-Float.valueOf("1")));
        BigDecimal decimal=new BigDecimal("100");
        BigDecimal decimal2=new BigDecimal("0.5");
        System.out.println(decimal.subtract(decimal2).setScale(2));
        System.out.println(decimal.subtract(decimal2).setScale(2,BigDecimal.ROUND_UNNECESSARY));


        System.out.println(subZeroAndDot(""+(Float.valueOf("100")-Float.valueOf("0.5"))));
        System.out.println(subZeroAndDot(""+(Float.valueOf("100")-Float.valueOf("1"))));
        System.out.println(subZeroAndDot(decimal.subtract(decimal2).setScale(2).toString()));
        System.out.println(subZeroAndDot(decimal.subtract(decimal2).setScale(2,BigDecimal.ROUND_UNNECESSARY).toString()));

        System.out.println(decimal.subtract(decimal2).setScale(2).toString());
        System.out.println(decimal.subtract(decimal2).setScale(1).toString());
//        System.out.println(decimal.subtract(decimal2).setScale(0).toString());
//        System.out.println(decimal.subtract(decimal2).setScale(0,BigDecimal.ROUND_UNNECESSARY).toString());

        System.out.println(new BigDecimal("1225.12").setScale(2));
        System.out.println(new BigDecimal("1225.1").setScale(2));
        System.out.println(new BigDecimal("1225").setScale(2));

        System.out.println(new BigDecimal("1225.120").setScale(2));//不会出错
//        System.out.println(new BigDecimal("1225.120").setScale(1));//出错原因精度丢失问题，要指定舍入模式即可
//        System.out.println(new BigDecimal("1225.121").setScale(2));//出错原因精度丢失问题，要指定舍入模式即可

        System.out.println(new BigDecimal("1225.120").setScale(1,BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal("1225.121").setScale(2,BigDecimal.ROUND_HALF_UP));
    }

    /**
     去掉结尾多余的0
     去掉结尾多余的 .和0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }


/*    //加法
    BigDecimal result1 = num1.add(num2);
    BigDecimal result12 = num12.add(num22);

    //减法
    BigDecimal result2 = num1.subtract(num2);
    BigDecimal result22 = num12.subtract(num22);

    //乘法
    BigDecimal result3 = num1.multiply(num2);
    BigDecimal result32 = num12.multiply(num22);

    //绝对值
    BigDecimal result4 = num3.abs();
    BigDecimal result42 = num32.abs();

    //除法
    BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
    BigDecimal result52 = num22.divide(num12,20,BigDecimal.ROUND_HALF_UP);*/
}
