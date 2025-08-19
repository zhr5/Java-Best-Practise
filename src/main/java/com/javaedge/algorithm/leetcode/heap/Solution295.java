package com.javaedge.algorithm.leetcode.heap;


import java.util.PriorityQueue;
import java.util.Queue;

public class Solution295 {
    class MedianFinder {
        Queue<Integer> minHeap, maxHeap;
        public MedianFinder() {
            minHeap = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            maxHeap = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
            //定义小顶堆元素数量=大顶堆的元素数量或＋1
        }
        public void addNum(int num) {
            if (minHeap.size() != maxHeap.size()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }
        public double findMedian() {
            return minHeap.size() != maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

}
