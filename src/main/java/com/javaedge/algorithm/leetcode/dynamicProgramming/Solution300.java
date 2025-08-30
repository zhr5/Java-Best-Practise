package com.javaedge.algorithm.leetcode.dynamicProgramming;

import java.util.Arrays;

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
    /**
     * 计算最长递增子序列的长度
     *
     * @param nums 输入的整数数组
     * @return 返回最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        // 如果输入数组为空，则最长递增子序列长度为0
        if(nums.length == 0) return 0;

        // 初始化dp数组，dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // 初始化结果变量为0，用于记录整个数组中的最长递增子序列长度
        int res = 0;

        // 初始化dp数组的所有元素为1，因为最短的递增子序列至少包含一个元素
        Arrays.fill(dp, 1);

        // 遍历数组，计算每个元素作为结尾的最长递增子序列的长度
        for(int i = 0; i < nums.length; i++) {
            // 对于每个元素，再从开头遍历到当前元素之前，寻找比当前元素小的元素
            for(int j = 0; j < i; j++) {
                // 如果找到比当前元素小的元素，更新当前元素的最长递增子序列长度
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // 更新全局最长递增子序列长度
            res = Math.max(res, dp[i]);
        }
        // 返回最长递增子序列的长度
        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
