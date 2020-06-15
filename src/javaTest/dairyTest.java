package javaTest;

import java.util.Random;

public class dairyTest {
        public static void main(String[] args) {
            String s = "Hello";
            System.out.println(s);
//            s = s.toUpperCase();
            
            System.out.println(s.toUpperCase());
            System.out.println(s);
            System.out.println(sum(10));
        }

    static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);

    }

    int[] disorder(int[] sz){
        int temp;
        int size=sz.length;
        Random random=new Random();
        int randomNum=random.nextInt(size);
        for (int i=0;i<sz.length;i++){
            temp=sz[i];
            sz[i]=sz[randomNum];
            sz[randomNum]=temp;
            randomNum=random.nextInt(size);
        }
        return sz;
    }

}
