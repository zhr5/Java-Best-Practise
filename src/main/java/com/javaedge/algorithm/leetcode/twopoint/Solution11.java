package com.javaedge.algorithm.leetcode.twopoint;

//盛最多水的容器
/*输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。*/
public class Solution11 {
    /*S(i,j)=min(h[i],h[j])x(j-i)*/
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[r] > height[l]) l++;
            else {
                r--;
            }
        }
        return max;
    }

}
