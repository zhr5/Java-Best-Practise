package com.javaedge.algorithm.leetcode.greedyAlgorithm;

public class Solution55 {
/*   给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。

    示例 1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    示例 2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。*/

    /**
     * 判断是否能够跳跃到最后一个位置
     * 使用贪心算法，维护一个最远可达位置的变量，遍历数组更新最远位置
     * @param nums 非负整数数组，每个元素表示在该位置可以跳跃的最大长度
     * @return 如果能够到达最后一个位置返回true，否则返回false
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        // 遍历数组，更新最远可达位置
        for (int i = 0; i < n; ++i) {
            // 只有当前位置可达时才进行更新
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                // 如果最远位置已经到达或超过最后一个位置，则返回true
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
