package com.javaedge.algorithm.leetcode.greedyAlgorithm;

public class Solution121 {
    //买卖股票的最佳时机
    // 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    // 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    // 注意：你不能在买入股票前卖出股票。
    // 示例 1:
    // 输入: [7,1,5,3,6,4]
    // 输出: 5
    // 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    // 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    // 示例 2:
    // 输入: [7,6,4,3,1]
    // 输出: 0
    // 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

    // 解题思路：
    // 贪心算法，只要当前价格大于等于之前的最小价格，就买入，否则就卖出。
    // 记录最小价格，最大利润，遍历数组，更新最小价格和最大利润。
    // 时间复杂度：O(n)，遍历数组一次。
    // 空间复杂度：O(1)，只用了两个变量。
    //题目要求只买卖一次
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
