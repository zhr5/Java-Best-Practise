package com.javaedge.algorithm.leetcode.trick;

/*给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，
        使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
        我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
        必须在不使用库内置的 sort 函数的情况下解决这个问题。
        示例 1：
        输入：nums = [2,0,2,1,1,0]
        输出：[0,0,1,1,2,2]
        示例 2：
        输入：nums = [2,0,1]
        输出：[0,1,2]

        提示：
        n == nums.length
        1 <= n <= 300
        nums[i] 为 0、1 或 2*/
public class Solution75 {
    public void sortColors(int[] nums) {
        int s0=0,s1=0,s2=0;
        for(int n:nums){
            if(n==0){
                s0++;
            }else if(n==1){
                s1++;
            }else{
                s2++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i<s0){
                nums[i]=0;
            }else if(i<(s0+s1)){
                nums[i]=1;
            }else{
                nums[i]=2;
            }
        }
    }
    /*public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }*/
}
