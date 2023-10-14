package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    public static final String          REGEX_TEXT = "<p>.*?</p>";
    public static final String          REGEX_TEXT_ALL = "<p>[\\s\\S]*?</p>";
    public static final String          REGEX_IMG = "img src=\'.*?\'";

    public static void main(String []args){

        System.out.println(isIdentity("中问吗有二十字吗有了吧","[\\u0391-\\uFFE5]{1,20}"));
        System.out.println(isIdentity("中问吗有二十字吗，有了吧","[\\u0391-\\uFFE5]{1,20}"));

        System.out.println(isIdentity("中问吗有二十字吗有了吧","[\\u4E00-\\u9FEA]{1,20}"));
        System.out.println(isIdentity("中问吗有二十字吗，有了吧","[\\u4E00-\\u9FEA]{1,20}"));

        String content="\u003cdiv style=\"display:flex;justify-content: space-between;\"\u003e\u003cdiv style=\"width:48%;\"\u003e\u003cimg src='https://micro.obs.cn-east-2.myhuaweicloud.com/Leviathan/user/const/2022/3/18/6c90ad10-59f1-4a83-80d5-0d48a2f40d34.jpg' style='width:100%;' /\u003e\u003c/div\u003e\u003c/div\u003e";
        String content2=content+content;
        String content3="<div style=\"display:flex;justify-content: space-between;\"><div style=\"width:48%;\"><img src='https://micro.obs.cn-east-2.myhuaweicloud.com/Leviathan/user/const/2022/3/28/7397d51b-7b0e-4c7f-a27b-3fd0eae7b7b9.jpg' style='width:100%;' /></div></div><p>牛股\n" +
                "哦菩提up</p>";
        String content4="<div style=\"display:flex;justify-content: space-between;\"><div style=\"width:48%;\"><img src='https://micro.obs.cn-east-2.myhuaweicloud.com/Leviathan/user/const/2022/3/28/7397d51b-7b0e-4c7f-a27b-3fd0eae7b7b9.jpg' style='width:100%;' /></div></div><p>牛股哦菩提up</p>";
      /*  // 创建 Pattern 对象
        Pattern REGEX_IMG = Pattern.compile("img src=\'.*?\'");

        // 现在创建 matcher 对象
        Matcher m = REGEX_IMG.matcher(content2);
        if (m.find( )) {
            System.out.println("Match number "+m.groupCount());
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
            System.out.println("substring: "+content.substring(m.start(),m.end()));
            System.out.println("Found value: " + m.group(0) );
            String group = m.group(0);
            System.out.println("Found value: " + group.substring(9,group.length()-1) );

        } else {
            System.out.println("NO MATCH");
        }*/
        getPatternContnet(REGEX_IMG,content,9,1);

        getPatternContnet(REGEX_TEXT,content4,3,4);
//        getPatternContnet(REGEX_TEXT,content3,3,4);
        getPatternContnet(REGEX_TEXT_ALL,content3,3,4);
    }

    private static void getPatternContnet(String REGEX,String content,int startIndex,int endIndex) {
        Pattern regexPattern = Pattern.compile(REGEX);

        // 现在创建 matcher 对象
        Matcher textMatcher = regexPattern.matcher(content);
        if (textMatcher.find( )) {
            System.out.println("Match number "+textMatcher.groupCount());
            System.out.println("start(): "+textMatcher.start());
            System.out.println("end(): "+textMatcher.end());
            System.out.println("substring: "+content.substring(textMatcher.start(),textMatcher.end()));
            System.out.println("Found value: " + textMatcher.group(0) );
            String group = textMatcher.group(0);
            System.out.println("Found value: " + group.substring(startIndex,group.length()-endIndex) );
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } else {
            System.out.println("NO MATCH");
        }
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
