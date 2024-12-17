package com.javaedge.algorithm.leetcode.dynamicProgramming;
/*给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
        子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
        例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的 子序列

        示例 1：
        输入：nums = [10,9,2,5,3,7,101,18]
        输出：4
        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
        示例 2：
        输入：nums = [0,1,0,3,2,3]
        输出：4
        示例 3：
        输入：nums = [7,7,7,7,7,7,7]
        输出：1

        提示：
        1 <= nums.length <= 2500
        -104 <= nums[i] <= 104*/
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            max = Math.max(max, dp[i]);
        }
        return max; // 最长递增子序列的长度
    }
}
