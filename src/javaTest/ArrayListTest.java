package javaTest;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    String content=null;
    public static void main(String []args){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(new Integer[]{
                1,2,3,4,5
        }));

        ArrayList<Integer> list2=new ArrayList<>(list);


        System.out.println(list);
        System.out.println(list2);

        list2.remove(2);
        list2.add(0,99);
        System.out.println(list);
        System.out.println(list2);

        System.out.println(list2.subList(0,2));
        System.out.println(list2);
    }
}
