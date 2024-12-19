package com.javaedge.algorithm.leetcode.trick;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow!= fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow!= fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
