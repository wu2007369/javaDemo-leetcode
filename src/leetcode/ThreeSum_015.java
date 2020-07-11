package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_015 {
    public static void main(String[] args) {
        int[] nums =new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
//        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }

    /**
     * 关键点是 排序+双指针
     * 1、从小到大排序，ij在前，k在后的类似双指针法
     * 2、nums[i]>0，则结束，无需计算sum
     * 3、sum<0时，j++；sum>0时，k--;  j>=k时，i++,j和k重新初始化
     * 4、sum==0则添加到总数组
     * 5、去重：
     * sum==0时，
     * while(num[k-1]==num[k]) k--;k--
     * while(num[j+1]==num[j]) j++;j++
     * while(num[i+1]==num[i]) i++;
     * 6、当i>=k-1时，结束
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> totalList = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = i + 1, k = nums.length - 1;
        while (i < k - 1 && (k - 1) >= 0 && (j + 1) < nums.length) {
            if (nums[i] > 0) {
                return totalList;
            }

            if (nums[i] + nums[j] + nums[k] > 0) {
                k--;

                if (j >= k) {
                    i++;
                    j = i + 1;
                    k = nums.length - 1;
                    continue;
                } else {
                    continue;
                }

            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;

                if (j >= k) {
                    i++;
                    j = i + 1;
                    k = nums.length - 1;
                    continue;
                } else {
                    continue;
                }

            } else {
                addToList_v2(totalList, nums[i], nums[j], nums[k]);
                while ((k - 1) >= 0&&nums[k - 1] == nums[k])
                    k--;
                while ((j + 1) < nums.length&&nums[j + 1] == nums[j])
                    j++;
                while (nums[i + 1] == nums[i] && (i + 1) < j)
                    i++;
                k--;

                if (j >= k) {
                    i++;
                    j = i + 1;
                    k = nums.length - 1;
                    continue;
                } else {
                    continue;
                }

            }
        }
        return totalList;

    }

    private static void addToList_v2(List<List<Integer>> totalList, int iValue, int jValue, int kValue) {
        List list = new ArrayList();
        list.add(iValue);
        list.add(jValue);
        list.add(kValue);
        totalList.add(list);
    }


    //用了三个for循环的沙比，马的，我就是
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> totalList = new ArrayList<>();
        boolean has3zero = false;

        for (int i = 0; i < nums.length - 2; i++) {
            int iValue = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int jValue = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int kValue = nums[k];
                    if ((iValue + jValue + kValue) == 0) {
                        if (iValue == jValue && jValue == kValue && kValue == 0) {
                            has3zero = true;
                            break;
                        }
                        addToList(totalList, iValue, jValue, kValue);
                    }
                }
            }
        }
        if (has3zero) {
            List list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            totalList.add(list);
        }

        return totalList;
    }

    private static void addToList(List<List<Integer>> totalList, int iValue, int jValue, int kValue) {
        int i = 0;
        for (; i < totalList.size(); i++) {
            List<Integer> childList = totalList.get(i);
            for (int value : childList) {
                if (childList.contains(iValue) && childList.contains(jValue) && childList.contains(kValue)) {
                    return;
                }
            }
        }
        if (i == totalList.size()) {
            List list = new ArrayList();
            list.add(iValue);
            list.add(jValue);
            list.add(kValue);
            totalList.add(list);
        }
    }
}
