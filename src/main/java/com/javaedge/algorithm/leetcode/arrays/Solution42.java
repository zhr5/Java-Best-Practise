package com.javaedge.algorithm.leetcode.arrays;

import java.util.Deque;
import java.util.LinkedList;

//接雨水
/*输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。*/
public class Solution42 {
    public static int trap(int[] height) {
        //O(n^2)
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) continue;
            int lHeight = height[i];//往左的最高点
            int rHeight = height[i];//往右的最高点
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;//只有h>0计入总数
        }
        return sum;
    }

    public static int trap1(int[] height) {
        //优化到O(n)
        int sum = 0;
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            int count = Math.min(leftmax[i], rightmax[i]) - height[i];
            if (count > 0) {
                sum += count;
            }
        }

        return sum;
    }

    //单调栈 --单调递减
    public static int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;//因为相隔一个才需要计算
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
