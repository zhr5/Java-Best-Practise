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

    /**
     * 计算给定高度图中可以 trap (接住) 的雨水总量
     * 该方法使用动态规划优化，将时间复杂度降低到O(n)
     *
     * @param height 一个整数数组，其中每个元素代表一根柱子的高度
     * @return 返回所有柱子可以 trap 的雨水总量
     */
    public static int trap1(int[] height) {
    // 优化到O(n)
    // 总水量
    int sum = 0;
    // leftmax[i] 表示从左到右遍历时，到位置i为止的最大高度
    int[] leftmax = new int[height.length];
    // rightmax[i] 表示从右到左遍历时，到位置i为止的最大高度
    int[] rightmax = new int[height.length];

    // 初始化 leftmax 数组的第一个元素
    leftmax[0] = height[0];
    // 从左向右遍历，记录每个位置左侧的最大高度
    for (int i = 1; i < height.length; i++) {
        leftmax[i] = Math.max(leftmax[i - 1], height[i]);
    }

    // 初始化 rightmax 数组的最后一个元素
    rightmax[height.length - 1] = height[height.length - 1];
    // 从右向左遍历，记录每个位置右侧的最大高度
    for (int i = height.length - 2; i >= 0; i--) {
        rightmax[i] = Math.max(rightmax[i + 1], height[i]);
    }

    // 遍历每个位置，计算该位置可以 trap 的水量，并累加到总水量
    for (int i = 0; i < height.length; i++) {
        // 当前位置可以 trap 的水量是由其左右两侧的最大高度中的较小值决定的
        int count = Math.min(leftmax[i], rightmax[i]) - height[i];
        // 只有当计算出的水量大于0时，才加入到总水量中
        if (count > 0) {
            sum += count;
        }
    }

    // 返回总水量
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

    //查问题
    /*public int trap3(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lh = height[i];
            int rh = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if(height[j]>lh){
                    lh=height[j];
                }
            }
            for (int k = i + 1; k < height[k]; k++) {
                if(height[k]>rh){
                    rh=height[k];
                }
            }
            int h = Math.min(lh, rh) - height[i];
            if (h > 0)
                res += h;
        }
        return res;
    }*/

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
