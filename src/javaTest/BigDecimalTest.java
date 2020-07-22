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
}
