package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class longestSubstringWithoutRepeatingCharacters_003 {
//    最朴素的实现方式
    public static int lengthOfLongestSubstring(String s) {
        int Max=1;
        char[] chars=s.toCharArray();
        if (s==null||s.length()==0){
            return 0;
        }
        int left=0,right=1;
        String temp=s.substring(left,right);
        //        这个判断不太严谨
        while (right<chars.length){
            right+=1;
            if (temp.contains(chars[right-1]+"")){
                left+=temp.indexOf(chars[right-1])+1;
            }
            temp=s.substring(left,right);
            if (Max<temp.length()){
                Max=temp.length();
            }
        }

        return Max;
    }

    public static void main(String []args){

        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

//    使用队列思想，使用工具queue或者set来实现
    public static int lengthOfLongestSubstring2(String s) {
        char[] chars=s.toCharArray();
        int max=0;
        LinkedList<Character> queue=new LinkedList<Character>();
        for (char c:chars){
            while (queue.contains(c)){
                queue.removeFirst();
            }
            queue.add(c);
            if (max<queue.size())
                max=queue.size();
        }
        return max;
    }

}
