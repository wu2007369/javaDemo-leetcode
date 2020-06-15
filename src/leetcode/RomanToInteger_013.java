package leetcode;

import java.util.*;

public class RomanToInteger_013 {
    public static void main(String []args){
        System.out.println(romanToInt2("III"));
    }

//    101ms
    public static int romanToInt(String s) {

        ArrayList<Character> list=new ArrayList<>(Arrays.asList('I','V','X','L','C','D','M'));
        ArrayList<Integer> list2= new ArrayList<>(Arrays.asList(1,5,10,50,100,500,1000));
        char[] charArray=s.toCharArray();
        Integer sum=0;
        int i=0;
        int indexFront=0;
        int indexBack=0;
        for (;i<charArray.length-1;i++){
            indexFront=list.indexOf(charArray[i]);
            indexBack=list.indexOf(charArray[i+1]);
            if (indexFront<indexBack)
                sum-=list2.get(indexFront);
            else
                sum+=list2.get(indexFront);
        }

        indexFront=list.indexOf(charArray[i]);
        sum+=list2.get(indexFront);
        return sum;
    }

//    44ms
    public static int romanToInt2(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] charArray=s.toCharArray();
        Integer sum=0;
        int i=0;
        int indexFront=0;
        int indexBack=0;
        for (;i<charArray.length-1;i++){
            indexFront=map.get(charArray[i]);
            indexBack=map.get(charArray[i+1]);
            if (indexFront<indexBack)
                sum-=indexFront;
            else
                sum+=indexFront;
        }
        indexFront=map.get(charArray[i]);
        sum+=indexFront;
        return sum;
    }

}
