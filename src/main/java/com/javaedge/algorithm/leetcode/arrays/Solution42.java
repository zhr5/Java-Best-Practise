package com.javaedge.algorithm.leetcode.arrays;

//接雨水
/*输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。*/
public class Solution42 {
    public static int trap(int[] height) {
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

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
