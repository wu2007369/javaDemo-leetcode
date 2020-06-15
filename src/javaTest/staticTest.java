package javaTest;

public  class staticTest {

    static int num=1;


    public static int getAbs(int a,int b){
        return -a*b;
    }


    public static int getAdd(int off){
        num+=off;
        return num;

    }

}


class SingleTon{

    private static final SingleTon instance=new SingleTon();
    private SingleTon(){}

    int num=1;

    public int getAbs(int a,int b){
        return -a*b;
    }


    public int getAdd(int off){
        num+=off;
        return num;

//        notify();
    }
}



