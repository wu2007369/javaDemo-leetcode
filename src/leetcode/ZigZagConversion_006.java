package leetcode;

public class ZigZagConversion_006 {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }

        char[] chars=s.toCharArray();
        int lenth=chars.length;
        int[] index=new int[lenth];
        int count=0;
        boolean isAdd=true;
        for (int i=0;i<lenth;i++){
//            index[i]=i%numRows;
            if (count==0){
                isAdd=true;
            }
            if ((count+1)==numRows){
                isAdd=false;
            }
            if (isAdd){
                index[i]=count++;
            }else {
                index[i]=count--;
            }

        }

        StringBuilder builder=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for (int j=0;j<lenth;j++){
                if (index[j]==i){
                    builder.append(chars[j]);
                }
            }
        }

        return builder.toString();
    }

    public static void main(String []args){
        System.out.println(new ZigZagConversion_006().convert("PAYPALISHIRING",1));
    }
}
