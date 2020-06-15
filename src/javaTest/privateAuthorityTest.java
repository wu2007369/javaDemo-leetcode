package javaTest;

public class privateAuthorityTest {
    private final int a;

    private  int b;
    public privateAuthorityTest(int a) {
        this.a = a;
    }

    public static void main(String []args){
        privateAuthorityTest pr=new privateAuthorityTest(100);
        pr.b=2;

        System.out.println(pr);
    }

    @Override
    public String toString() {
        return "privateAuthorityTest{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
