package javaTest;

import utils.CommonUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class deepCopyTest {
    public static void main(String []args){
//        Integer[] arrays=new Integer[]{};
        List<Integer> list= Arrays.asList(new Integer[]{1,2,3,4,5});
        List<Integer> shallowList=list;
        List<Integer> deepList= CommonUtils.deepCopy(Integer.class,list);
        List<Integer> testList= setTest(list);
        List<Integer> testAddAllList= new ArrayList<>();
        testAddAllList.addAll(list);
        //TODO Attetion ：这是不被允许操作的.Array转型承德list是有长度限制的
//        list.addAll(list);
//        list.add(0);

        shallowList.set(0,shallowList.get(4));
        System.out.println(list);
        System.out.println(shallowList);
        System.out.println(deepList);

        list.set(1,99);
        System.out.println(list);
        System.out.println(shallowList);
        System.out.println(deepList);//Collections.copy 方法 是新链表对象，但是元素还是相同引用，即相同对象
        System.out.println(testList);//遍历+set方法 出来的链表 是新链表对象，但是元素还是相同引用，即相同对象
        System.out.println(testAddAllList);//addAll出来的链表 是新链表对象，但是元素还是相同引用，即相同对象
        //法4 json序列化以及反序列化，既是新链表对象，内部元素也都是新的对象，而不是统一引用


    }

    private static List<Integer> setTest(List<Integer> list){
        List<Integer> testList=new ArrayList<>();
        Integer[] array = (Integer []) Array.newInstance(Integer.class,list.size());
        testList.addAll(Arrays.asList(array));

        for (int i=0;i<list.size();i++){
            testList.set(i,list.get(i));
        }
        return testList;

    }
}
