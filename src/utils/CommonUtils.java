package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommonUtils {
    /**
     * 实现list的深拷贝
     * @param tClass
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> deepCopy(Class<T> tClass,List<T> list){
        //list深度拷贝
        List<T> newList = new ArrayList<>();
        T[] array = (T[]) Array.newInstance(tClass,list.size());
        newList.addAll(Arrays.asList(array));
        Collections.copy(newList, list);
        return newList;
    }
}
