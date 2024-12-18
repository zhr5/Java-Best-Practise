package com.javaedge.algorithm.leetcode.greedyAlgorithm;

public class Solution45 {
    public int jump(int[] nums) {
        //题目说明一定可以到达最后一个位置，因此不需要考虑数组长度小于2的情况
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);// 记录当前能跳到的最远位置
            if (i == end) {// 如果当前位置已经到达了最远位置，则更新end和steps
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
