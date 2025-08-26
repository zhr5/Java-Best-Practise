package com.javaedge.algorithm.leetcode.dynamicProgramming;

public class Solution70 {
    // ... existing code ...

    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * <p>
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 需要爬的台阶数
     * @return 到达楼顶的不同方法数
     */
    public int climbStairs(int n) {
        // 基础情况：当台阶数小于等于2时，方法数等于台阶数
        if (n <= 2) return n;
        // 使用动态规划思想，只保存前两个状态值以节省空间
        int d1 = 1, d2 = 2;
        // 从第3阶开始计算到第n阶的方法数
        for (int i = 3; i <= n; i++) {
            // 当前阶数的方法数等于前一阶和前两阶方法数之和
            int d3 = d1 + d2;
            // 更新状态值，向前推进
            d1 = d2;
            d2 = d3;
        }
        return d2;
    }

    public int climbStairs1(int n) {
        if (n <= 1)
            return n;
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        d[2] = d[0] + d[1];
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }
}
