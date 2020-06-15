package javaTest;

public class functionParameter {
    public static void main(String []args){
        int a=2;
        int b=3;
        System.out.println(changeVal(a,b));
        System.out.println(a);
        System.out.println(b);
    }

    private static int changeVal(int a,int b){
        int sum;
        a+=1;
        b+=2;
        sum=a+b;
        return sum;
    }
}
