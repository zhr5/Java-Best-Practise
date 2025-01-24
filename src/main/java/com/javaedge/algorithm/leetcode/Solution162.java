package com.javaedge.algorithm.leetcode;

public class Solution162 {
    public static void main(String[] args) {
        Solution162 solution = new Solution162();
        int[] nums = {1, 2, 3, 1};
        int peakIndex = solution.findPeakElement(nums);
        System.out.println("峰值元素的索引为：" + peakIndex);
    }
    public int findPeakElement1(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
    /**
     * 寻找峰值元素的索引
     * 峰值元素是指其值大于左右相邻值的元素
     * 本方法通过二分查找的方式高效地找到一个峰值元素的索引
     *
     * @param nums 输入的整数数组，其中包含至少一个峰值元素
     * @return 返回找到的峰值元素的索引
     */
    public int findPeakElement(int[] nums) {
        // 初始化左右指针
        int left = 0, right = nums.length - 1;

        // 当左指针小于右指针时，进行循环
        while (left < right) {
            // 计算中间位置，避免整数溢出
            int mid = left + (right - left) / 2;

            // 如果中间元素大于其右侧元素，则峰值在左侧或就是中间元素
            if (nums[mid] > nums[mid + 1]) {
                // 将右指针移动到中间，继续查找
                right = mid;
            } else {
                // 否则，峰值在右侧
                // 将左指针移动到中间元素的右侧，继续查找
                left = mid + 1;
            }
        }

        // 当左右指针相遇时，即找到峰值元素，返回左指针即可
        return left;
    }
}
