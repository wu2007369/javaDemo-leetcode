package leetcode;

import java.util.ArrayList;

public class MedianofTwoSortedArrays_004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0) {
            return getMedian(nums2);
        }
        if (nums2.length==0) {
            return getMedian(nums1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        int lenth = nums2.length;
        //nums1比nums2晚结束的情况
        for (int a : nums1) {
            while (j < lenth && a > nums2[j]) {
                list.add(nums2[j]);
                j++;
            }
            list.add(a);
        }
        //nums1比nums2早结束的情况
        while (j < lenth) {
            list.add(nums2[j]);
            j++;
        }

        Integer listArray[] = new Integer[list.size()];
        return getMedian(list.toArray(listArray));
    }

    public static void main(String[] args) {
        System.out.println(new MedianofTwoSortedArrays_004().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));

    }

    private double getMedian(int nums[]) {
        int size = nums.length;
        int median = size / 2;

        if (size % 2 == 0) {
            return (double) (nums[median] + nums[median - 1]) / 2;
        } else {
            return (double) nums[median];
        }
    }

    private double getMedian(Integer nums[]) {
        int size = nums.length;
        int median = size / 2;

        if (size % 2 == 0) {
            return (double) (nums[median] + nums[median - 1]) / 2;
        } else {
            return (double) nums[median];
        }
    }
}
