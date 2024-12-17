package com.javaedge.algorithm.leetcode.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution347 {
/*   给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    示例 1:
    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:
    输入: nums = [1], k = 1
    输出: [1]*/

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        //新建小顶堆,按照Map的value对key排序
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        for (int n : count.keySet()) {//遍历key集合
            heap.add(n);
            if (heap.size() > k)
                heap.poll();//把频率最小的弹出
        }

        int[] res = new int[heap.size()];
        int i = 0;
        while (!heap.isEmpty())
            res[i++] = heap.poll();

        return res;
    }
}
