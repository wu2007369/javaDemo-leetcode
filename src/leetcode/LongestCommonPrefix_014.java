package leetcode;

public class LongestCommonPrefix_014 {
    public String longestCommonPrefix2(String[] strs) {
        String commonPrefix="";

//        for (int i=0;;i++){
//            for (int j=0;j<strs.length;j++){
//                if (i>=strs[j].length()){
//                    return commonPrefix;
//                }
//
//                if (strs[j].valueOf(i))
//            }
//        }

        return commonPrefix;
    }


    public String longestCommonPrefix1(String[] strs) {
        if (strs.length==0)
            return "";
        else if (strs.length==1)
            return strs[0];

        char[] a=strs[0].toCharArray();
        char[] b;
        int index=a.length-1;
        int min=0;

        for (int i=1;i<strs.length;i++){
            b=strs[i].toCharArray();

            min=a.length<b.length?a.length:b.length;
            min=min<(index+1)?min:(index+1);//min不是作为索引下标使用，而是作为for循环上限使用的，需要比索引+1
            index=-1;//每次在for 循环判断中，计算公共前缀的索引下标时，将其初始化为最小数

            if (min==0)
                return "";

            for (int j=0;j<min;j++){
                if (Character.compare(a[j],b[j])==0){
                    index=j;
                }else {
                    break;
                }
            }
        }


        if (index==-1)
            return "";
        else
            return strs[0].substring(0,index+1);
    }
        public static void main(String []args){

        LongestCommonPrefix_014 test=new LongestCommonPrefix_014();
//        String[] strs={"flower","flow","flight"};
//        String[] strs={"dog","racecar","car"};
//            String[] strs={""};
//            String[] strs={"",""};
//            String[] strs={"c","c"};
//            String[] strs={"c"};
            String[] strs={"aca","cba"};
        System.out.println(test.longestCommonPrefix1(strs));
    }

}
