package javaTest;

import utils.CommonUtils;

import java.util.Arrays;
import java.util.List;

public class deepCopyTest {
    public static void main(String []args){
//        Integer[] arrays=new Integer[]{};
        List<Integer> list= Arrays.asList(new Integer[]{1,2,3,4,5});
        List<Integer> shallowList=list;
        List<Integer> deepList= CommonUtils.deepCopy(Integer.class,list);

        shallowList.set(0,shallowList.get(4));
        System.out.println(list);
        System.out.println(shallowList);
        System.out.println(deepList);

        deepList.set(1,99);
        System.out.println(list);
        System.out.println(deepList);
    }
}
