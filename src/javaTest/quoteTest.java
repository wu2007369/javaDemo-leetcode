package javaTest;

public class quoteTest {
    public static void main(String []args){
        int quoteA=3;
        Object obj=quoteA;
        quoteA++;
        System.out.println(quoteA);
        System.out.println((int)obj);
        //基本类型 是值传递 而不是引用传递
    }
}
