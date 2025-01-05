package com.javaedge.algorithm.leetcode.dynamicProgramming;

public class Solution416 {
   public boolean canPartition(int[] nums) {
        // 计算数组所有元素的总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果总和为奇数，则不可能将数组分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }
        // 目标值为总和的一半
        int target = sum / 2;
        // 使用布尔数组dp，dp[i]表示是否可以通过数组中的某些元素得到和为i
        boolean[] dp = new boolean[target + 1];
        // 初始化dp[0]为true，表示和为0总是可以实现的（不选择任何元素）
        dp[0] = true;
        // 遍历每个数字，更新dp数组
        for (int num : nums) {
            // 从后向前更新dp数组，避免使用到当前数字更新过的结果
            for (int i = target; i >= num; i--) {
                // 这段代码用于更新动态规划数组dp的第i个元素，如果dp[i]未被赋值，则将其赋值为dp[i - num]
               dp[i] = dp[i] || dp[i - num];
            }
        }
        // 返回dp[target]，即是否可以得到和为目标值的子集
        return dp[target];
    }

}
