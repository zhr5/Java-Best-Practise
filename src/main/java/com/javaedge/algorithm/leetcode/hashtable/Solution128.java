package com.javaedge.algorithm.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

//最长连续子序列
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
public class Solution128 {
    public int longestConsecutive(int[] nums) {

    }
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};// 1-2-3-4 ->4
        Solution128 solution128=new Solution128();
        System.out.println(solution128.longestConsecutive(nums));
    }
}
