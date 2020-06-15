package leetcode;

import java.util.ArrayList;

public class ReverseInteger_007 {
    public static void main(String []args){
        int i=1<<31;
        System.out.println(i);
        System.out.println(i%10);
        System.out.println(i-1);
        ReverseInteger_007 r=new ReverseInteger_007();
        System.out.println(r.reverse(1534236469));
    }

    public int reverse(int x) {
        int extrenm=(1 << 31);
        if (x>=(extrenm-1)||x<=extrenm)
            return 0;
        boolean isMinus=false;
        if (x<0){
            isMinus=true;
            x=-x;
        }

        ArrayList<Integer> arrays=new ArrayList<>();
        //最危险的地方在于，计算过程中也会产生溢出int型的情况
//        所以解决办法是，使用long类型来计算，知道最后返回时加上判断
//        并且正常返回时，使用类型转换
        long num=0;
        while (x>0){
            arrays.add(x%10);
            x/=10;
        }
        for (int i:arrays){
            num*=10;
            num+=i;
            System.out.println(num);

        }
        if (isMinus)
            num=-num;
        if (num>=(extrenm-1)||num<=extrenm)
            return 0;
        return Integer.parseInt(num+"");
    }
}
