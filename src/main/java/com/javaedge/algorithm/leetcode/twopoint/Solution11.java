package com.javaedge.algorithm.leetcode.twoPoint;

//盛最多水的容器
/*输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。*/
public class Solution11 {
    /*S(i,j)=min(h[i],h[j])x(j-i)*/
    /**
     * 计算能够装最多水的两个点之间的面积
     * 通过使用双指针法，从数组的两端开始向中间移动，以找到最大的面积
     *
     * @param height 一个整数数组，代表每个点的高度
     * @return 返回能够装最多水的两个点之间的面积
     */
    public int maxArea(int[] height) {
        // 初始化左指针l、右指针r和最大面积max
        int l = 0, r = height.length - 1, max = 0;

        // 当左指针小于右指针时，执行循环
        while (l < r) {
            // 更新最大面积，当前面积由两个指针指向的点的较小高度和指针之间的距离决定
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));

            // 移动指针，如果右指针指向的高度大于左指针指向的高度，则左指针右移
            if (height[r] > height[l]) {
                l++;
            } else {
                // 否则，右指针左移
                r--;
            }
        }

        // 返回最大面积
        return max;
    }

}
