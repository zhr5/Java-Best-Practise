package com.javaedge.algorithm.leetcode.twopoint;

//移动0
/*输入: nums = [0,1,0,3,12]
        输出: [1,3,12,0,0]*/
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[index++] = 0;
        }
    }
}
