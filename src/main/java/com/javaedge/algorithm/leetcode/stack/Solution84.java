package com.javaedge.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//柱形图中的最大矩形
/*输入：heights = [2,1,5,6,2,3]
        输出：10
        解释：最大的矩形为图中红色区域，面积为 10*/
public class Solution84 {
    /**
     * 计算柱状图中能勾勒出的最大矩形面积
     * <p>
     * 解题思路：
     * 1. 对于每个柱子，找出以它为高的最大矩形面积
     * 2. 使用单调栈分别计算每个柱子左侧和右侧第一个小于它的柱子位置
     * 3. 根据左右边界计算矩形面积并取最大值
     *
     * @param heights 柱子高度数组，其中 heights[i] 表示第 i 个柱子的高度
     * @return 最大矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // left[i] 记录第 i 根柱子左侧第一个小于它的柱子索引
        int[] left = new int[n];
        // right[i] 记录第 i 根柱子右侧第一个小于它的柱子索引
        int[] right = new int[n];
        Arrays.fill(right, n);

        // 单调增栈，用于寻找每个柱子左右两侧第一个较小元素
        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            // 当栈不为空且栈顶元素大于等于当前元素时，更新栈顶元素的右边界
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            // 确定当前元素的左边界
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        // 遍历所有柱子，计算以每个柱子为高的最大矩形面积
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
/*
       对于每个柱子，我们需要确定以它为高的最大矩形面积。
        关键在于找到这个柱子左侧和右侧第一个比它矮的柱子，
        这两个位置之间的区域就是以当前柱子高度为矩形高的最大宽度

        索引:  0  1  2  3  4  5
        高度:  2  1  5  6  2  3
                      ↑  ↑
                  当前柱子5

        左侧第一个小于5的柱子: 索引1(高度1)
        右侧第一个小于5的柱子: 索引4(高度2)

        可以形成高度为5的矩形范围: 索引[2,3]
        宽度 = 4 - 1 - 1 = 2
        面积 = 5 × 2 = 10

        为什么取heights[mono_stack.peek()] >= heights[i]
        heights = [3, 2, 2, 3]
        条件	left[]	right[]	关键差异点
       <	[-1, -1, 1, 2]	 [1, 4, 4, 4]	中间两个 2 的left[2]=1（互相视为左侧边界），right[1]=4（右侧边界错误延伸）。
      <=	[-1, -1, -1, 2]	 [1, 2, 4, 4]	中间两个 2 的left[2]=-1（左侧无更矮柱子），right[1]=2（右侧边界正确更新）。



*/
