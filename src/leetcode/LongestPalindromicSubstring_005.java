package leetcode;

import java.util.LinkedList;

public class LongestPalindromicSubstring_005 {
    public String longestPalindrome(String s) {
        //输入为空时的特殊判断
        if (null==s){
            return "";
        }
        if (s.length()==0){
            return "";
        }

        //插入#字符，构造S字符数组
        StringBuilder builder=new StringBuilder();
        builder.append("$#");
        for (char c:s.toCharArray()){
            builder.append(c);
            builder.append("#");
        }
        builder.append("%");
        char[] S=builder.toString().toCharArray();

        //构造与S字串相同大小size的P字符数组
        int[] P=new int[S.length];

        //id为当前回文字串的中心（下标/index），max为id对应的回文字串的右边边界（下标/index）
        int max = 0, id = 0;

        //用来获取，最大回文半径时，回文字串的中间值下标和半径
        int maxCenterIndex=0,maxRadiuslenth=0;

        for (int i=1;i<S.length-1;i++){
            P[i]=max>i?Math.min(P[2*id-i],max-i):1;

            //向左向右扩展匹配，如果两边字符相同则为回文字串，且P[i]回文半径+1
            while (S[i-P[i]]==S[i+P[i]]){
                P[i]++;
            }

            //max回文边界扩大; id值跟着i遍历到下一个
            if (i+P[i]>max){
                max=i+P[i];
                id=i;
            }

            if (maxRadiuslenth<P[i]){
                maxRadiuslenth=P[i];
                maxCenterIndex=i;
            }
        }

        return s.toString().substring((maxCenterIndex-maxRadiuslenth)/2,(maxCenterIndex-maxRadiuslenth)/2+maxRadiuslenth-1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring_005().longestPalindrome("babad"));
    }

    private String getStringfromArray(LinkedList<Character> queue) {
        char chars[] = new char[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            chars[i] = queue.get(i);
        }
        return String.valueOf(chars);
    }

/*    public String longestPalindrome(String s) {
        //输入为空时的特殊判断
        if (null==s){
            return "";
        }
        if (s.length()==0){
            return "";
        }


        //插入#字符，构造S字符数组
        StringBuilder builder=new StringBuilder();
        builder.append("$#");
        for (char c:s.toCharArray()){
            builder.append(c);
            builder.append("#");
        }
        builder.append("%");
        char[] S=builder.toString().toCharArray();



        //构造与S字串相同大小size的P字符数组
        int[] P=new int[S.length];

        //id为当前回文字串的中心（下标/index），max为id对应的回文字串的右边边界（下标/index）
        int max = 0, id = 0;

        //用来获取，最大回文半径时，回文字串的中间值下标和半径
        int maxCenterIndex=0,maxRadiuslenth=0;

        for (int i=1;i<S.length-1;i++){
            P[i]=max>i?Math.min(P[2*id-i],max-i):1;

            //向左向右扩展匹配，如果两边字符相同则为回文字串，且P[i]回文半径+1
            while (S[i-P[i]]==S[i+P[i]]){
                System.out.print("i="+i+";"+"P[i=]"+P[i]+";");
                System.out.println("S[i-P[i]]="+S[i-P[i]]+";S[i+P[i]]="+S[i+P[i]]);
                P[i]++;
            }

            //max回文边界扩大; id值跟着i遍历到下一个
            if (i+P[i]>max){
                max=i+P[i];
                id=i;
            }

            if (maxRadiuslenth<P[i]){
                maxRadiuslenth=P[i];
                maxCenterIndex=i;
            }
        }

        System.out.println("S="+builder.toString());
        System.out.print("P=");
        for (int a:P){
            System.out.print(a);
        }
        System.out.println("\nmaxCenterIndex="+maxCenterIndex+";maxRadiuslenth="+maxRadiuslenth);

        System.out.println(s);
        return s.toString().substring((maxCenterIndex-maxRadiuslenth)/2,(maxCenterIndex-maxRadiuslenth)/2+maxRadiuslenth-1);
    }*/


}
