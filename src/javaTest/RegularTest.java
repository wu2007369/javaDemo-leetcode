package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    public static void main(String []args){

        System.out.println(isIdentity("中问吗有二十字吗有了吧","[\\u0391-\\uFFE5]{1,20}"));
        System.out.println(isIdentity("中问吗有二十字吗，有了吧","[\\u0391-\\uFFE5]{1,20}"));

        System.out.println(isIdentity("中问吗有二十字吗有了吧","[\\u4E00-\\u9FEA]{1,20}"));
        System.out.println(isIdentity("中问吗有二十字吗，有了吧","[\\u4E00-\\u9FEA]{1,20}"));
    }

    /**
     * 判断是否是 匹配正则表达式
     * @param content
     * @param patternValue
     * @return
     */
    public static boolean isIdentity(String content,String patternValue) {

        Pattern p = Pattern.compile(patternValue);
        Matcher m = p.matcher(content);
        return m.matches();
    }
}
