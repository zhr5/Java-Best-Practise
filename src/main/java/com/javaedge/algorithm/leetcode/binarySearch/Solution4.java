package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution4 {
    //寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0; // 两个数组的指针
        int left = 0, right = 0; // 记录中间位置的两个值
        int totalLength = nums1.length + nums2.length;
        int m = totalLength / 2; // 中间位置索引（总长度为偶数时需取m-1和m）
        int count = 0; // 计数器，用于追踪遍历到第几个元素

        // 遍历到第m个元素（0-based）
        while (count <= m) {
            left = right; // 保存上一个值（用于偶数长度时计算平均）

            // 核心逻辑：选择当前较小的元素，避免数组越界
            if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                // 取nums1的元素：nums2已遍历完，或nums1当前元素更小
                right = nums1[i++];
            } else {
                // 取nums2的元素
                right = nums2[j++];
            }

            count++;
        }

        // 根据总长度奇偶性返回结果
        if (totalLength % 2 == 0) {
            return (left + right) / 2.0; // 偶数：中间两个数的平均值
        } else {
            return right; // 奇数：中间的数
        }
    }
}
