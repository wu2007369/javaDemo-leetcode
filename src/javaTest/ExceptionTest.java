package javaTest;

public class ExceptionTest {
    public static void main(String []args){
        String A="";
        if (true){
            A=null;
        }
        System.out.println(A);

        try {
            System.out.println(A.indexOf("a"));
        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            System.out.println("in finally 能打印出来吗");

        }

        System.out.println(A.indexOf("能打印出来吗"));

    }
}
