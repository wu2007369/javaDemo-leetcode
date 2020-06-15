package leetcode;

import java.util.ArrayList;

public class TwoSum_001 {
    public static void main(String[] args){
        TwoSum_001 t=new TwoSum_001();
        int [] nums={2,7,11,15};
        System.out.println("从撒大城市的 v 时代 ");
        System.out.println(nums[0]+nums[1]);
        System.out.println(t.twoSum(nums,9).toString());

    }



    public int[] twoSum(int[] nums, int target) {
        int []arrays=new int [2];
        for (int i=0;i<(nums.length-1);i++){
            for (int j=(i+1);j<nums.length;j++){
                if (target==(nums[i]+nums[j])){
                    arrays[0]=i;
                    arrays[1]=j;
                    return arrays;
                }
            }
        }
        return arrays;

    }

    public Integer[] twoSum2(int[] nums, int target) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        Integer [] arrays=new Integer[lists.size()];
        Integer [] arrays2=lists.toArray(arrays);
        return  arrays2;
    }
}
