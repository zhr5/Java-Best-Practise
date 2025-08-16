package com.javaedge.algorithm.leetcode.heap;

import java.util.PriorityQueue;

public class Solution215 {
    /**
     * 查找数组中第K大的元素
     * 使用最小堆维护数组中最大的K个元素，堆顶即为第K大元素
     * @param nums 输入的整数数组
     * @param k 要查找的第K大元素的位置
     * @return 数组中第K大的元素值
     */
    //数组中的第K大元素
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);//默认小跟堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);//大根堆创建方法

        // 初始化堆，将前k个元素加入最小堆
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // 遍历剩余元素，维护大小为k的最小堆
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

}
