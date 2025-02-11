package com.javaedge.algorithm.leetcode.slidingWindow;


import java.util.ArrayDeque;

public class Solution239 {

    //暴力解法 时间复杂度为 O((n−k+1)k)≈O(nk)
    //单调栈
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();//存储下标,保证单调递减，保证队列头结点最大
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!stack.isEmpty() && stack.peek() < i - k + 1){
                stack.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                stack.pollLast();
            }

            stack.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[stack.peek()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k=3;
        Solution239 s = new Solution239();
        int [] res = s.maxSlidingWindow(nums, k);
        for(int i:res){
            System.out.print(i);
        }
    }
}
