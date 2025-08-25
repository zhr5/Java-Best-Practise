package com.javaedge.algorithm.leetcode.greedyAlgorithm;

public class Solution45 {

    /**
     * 计算跳跃游戏的最少跳跃次数
     * 使用贪心算法，每次在可跳跃范围内选择能跳得最远的位置进行跳跃
     *
     * @param nums 非负整数数组，表示每个位置可以跳跃的最大长度
     * @return 到达数组最后一个位置所需的最少跳跃次数
     */
    public int jump(int[] nums) {
        // **走到必须跳的时候再跳，并且跳到能到达最远位置的地方**
        //题目说明一定可以到达最后一个位置，因此不需要考虑数组长度小于2的情况
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);// 记录当前能跳到的最远位置
            if (i == end) {// 如果当前位置已经到达了最远位置，则更新end和steps
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

/*比如数组 [2, 3, 1, 1, 4]：

第0个位置，能跳到的最远位置是 0+2=2
        - 当前跳跃区间: [0, 0]
        - 下一跳能覆盖的最远位置: 2
        - 当i=0时到达区间末尾，必须跳了，steps=1

第1、2位置，能跳到的最远位置分别是 1+3=4 和 2+1=3
        - 当前跳跃区间: [1, 2]
        - 下一跳能覆盖的最远位置: max(4, 3) = 4
        - 当i=2时到达区间末尾，必须跳了，steps=2

此时最远位置已经是4，已经到达终点，结束。
i=0 maxPosition=2 steps=1 end=2
i=1 maxPosition=4 steps=1 end=4
i=2 maxPosition=4 steps=2 end=4
i=3 maxPosition=4 steps=2 end=4
*/
