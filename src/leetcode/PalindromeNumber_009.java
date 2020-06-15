package leetcode;

import java.util.ArrayList;

public class PalindromeNumber_009 {
    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        ArrayList<Integer> list=new ArrayList<>();
        while (x>0){
            list.add(x%10);
            x/=10;
        }
        int size=list.size();
        for (int i=0;i<(size-i-1);i++){
            if (list.get(i)!=list.get(size-1-i))
                return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        String a=x+"";
        String b=new StringBuffer(a).reverse().toString();
        if (a.equals(b))
            return true;
        else
            return false;
    }
}
