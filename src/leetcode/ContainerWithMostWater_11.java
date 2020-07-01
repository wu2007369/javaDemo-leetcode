package leetcode;

/**
 * 这道应用题，怎么开始，怎么结束
 * area=minHeight*length
 * 最佳解，双指针
 * 双指针代表的是 可以作为容器边界的所有位置的范围
 */
public class ContainerWithMostWater_11 {

    public static void main(String []args){
        System.out.println();
    }

    public int maxArea(int[] height) {

        int max=0;
        for (int i=0;i<height.length-1;i++){
            for (int j=(i+1);j<height.length;j++){
                int area=Math.min(height[i],height[j])*(j-i);
                if (area>max){
                    max=area;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max=0;
        for (int i=0,j=(height.length-1);i<j;){
            int area=Math.min(height[i],height[j])*(j-i);
            if (area>max){
                max=area;
            }

            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }

        }
        return max;
    }
}
