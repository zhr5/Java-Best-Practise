package com.javaedge.algorithm.leetcode.arrays;

import java.util.Arrays;

public class Solution238 {
    /**
     * 计算数组中每个元素除自身以外的乘积。
     * 该函数通过两次遍历数组，分别计算每个元素左侧和右侧的乘积，最终得到结果。
     *
     * @param nums 输入的整数数组，包含需要计算乘积的元素。
     * @return 返回一个整数数组，其中每个元素是输入数组中对应位置元素除自身以外的乘积。
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        // 第一次遍历：计算每个元素左侧的乘积，并存储在结果数组中。
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }

        // 第二次遍历：计算每个元素右侧的乘积，并与左侧乘积相乘，得到最终结果。
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution238 solution = new Solution238();
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));  // 输出结果：[24, 12, 8, 6]
    }
}
