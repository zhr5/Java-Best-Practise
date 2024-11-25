package com.javaedge.algorithm.leetcode.arrays;

public class Solution53 {
    /* 动态规划的核心思想：
     动态规划算法通常需要在每一步计算当前状态的最优解，并在此基础上逐步构建最终的最优解。
     在这个问题中，dp[i] 记录了以第 i 个元素结尾的最大子数组和，但最终我们需要的是整个数组中的最大子数组和，而不仅仅是最后一个元素结尾的最大子数组和。
     全局最优解：
     dp[i] 只记录了以第 i 个元素结尾的最大子数组和，但整个数组的最大子数组和可能出现在任何一个位置。因此，需要一个额外的变量 max 来记录遍历过程中遇到的最大值。
     避免遗漏：
     如果不使用 max 变量，只返回 dp[nums.length - 1]，可能会遗漏掉前面已经计算出的更大值。例如，如果数组的前半部分有一个较大的子数组和，
     而后面的部分都是负数，那么 dp[nums.length - 1] 可能会是一个较小的值。*/
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
