package javaTest;

import javaTest.interfa.TestInterface;

public class InterfaceTest {

    public static void main(String []args){
        TestInterface in=new TestInterface() {
            @Override
            public void run() {
                System.out.println("xcko;lxkop;aklx");
                System.out.println(this.name);

                //果然是默认的public static类型
                System.out.println(TestInterface.name);

            }
        };
        //接口可以用匿名内部类实现。那么kotlin的obect:方式也是可以实现的了。
        in.run();
    }
}
