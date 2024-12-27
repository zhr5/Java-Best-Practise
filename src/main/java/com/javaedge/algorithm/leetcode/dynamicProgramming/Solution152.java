package com.javaedge.algorithm.leetcode.dynamicProgramming;

/*给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组
        （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
        测试用例的答案是一个 32-位 整数。
        示例 1:
        输入: nums = [2,3,-2,4]
        输出: 6
        解释: 子数组 [2,3] 有最大乘积 6。
        示例 2:
        输入: nums = [-2,0,-1]
        输出: 0
        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
        提示:
        1 <= nums.length <= 2 * 104
        -10 <= nums[i] <= 10
        nums 的任何子数组的乘积都 保证 是一个 32-位 整数*/
public class Solution152 {
    public int maxProduct(int[] nums) {
 /*       int [] [] dp =new int [nums.length][nums.length];//dp[i][j]表示【i,j】乘积最大的非空连续 子数组

        for(int i=0;i<nums.length;i++){
            dp[i][i]=nums[i];
        }

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]*dp[i][j-1]>0){
                    dp[i][j]=nums[i]*dp[i][j-1];
                }else if(nums[i]*dp[i][j-1]<0){
                    if(dp[i][j-1])
                }

            }
        }*/
        long maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            long mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            if (minF < -1 << 31) {
                minF = nums[i];
            }
            ans = Math.max((int) maxF, ans);
        }
        return ans;

    }
}
