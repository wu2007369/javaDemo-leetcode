package javaTest;

import javaTest.abstra.AbstractParent;

public class AbstractTest {
    public static void main(String []args){
        AbstractParent parent=new AbstractParent() {
            @Override
            public void run() {
                System.out.println("你说呢，吃嘛嘛香");
            }
        };

        parent.run();
    }
}
