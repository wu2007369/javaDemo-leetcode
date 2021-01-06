package javaTest;

public class TrimTest {
    public static void main(String []args){
        String start="start";
        String end="end";
        String content=" abcde fghw ";
        System.out.println(start+content+end);
        System.out.println(start+content.trim()+end);
    }
}
