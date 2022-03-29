package javaTest;

public class NullTest {
    private String name="name";
    private String content;
    public static void main(String []args){
        try {


//        NullTest test=null;
        NullTest test=new NullTest();
//        System.out.println(test);
        System.out.println(test.name);
        System.out.println(test.content);
        System.out.println(test.content.length());
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
