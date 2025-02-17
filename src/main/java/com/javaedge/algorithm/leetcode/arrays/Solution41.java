package com.javaedge.algorithm.leetcode.arrays;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    //哈希表(使用负号表示已访问)  和矩阵置0有点像，但是不太一样
    // 时间复杂度O(n) 空间复杂度O(1)
    /**
     * 查找数组中缺失的最小正整数。
     * 该函数通过将数组中的元素作为索引，利用负号标记已访问的元素，从而在O(n)时间复杂度和O(1)空间复杂度内找到缺失的最小正整数。
     *
     * @param nums 输入的整数数组，可能包含正数、负数和零。
     * @return 返回数组中缺失的最小正整数。
     */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;

        // 将数组中的非正数替换为n+1，以便后续处理时忽略这些无效值
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 遍历数组，将每个有效正整数的对应索引位置标记为负数，表示该正整数已存在
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 再次遍历数组，找到第一个未被标记为正数的位置，返回对应的正整数
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 如果数组中所有正整数都存在，则返回n+1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        Solution41 solution41 = new Solution41();
        int firstMissingPositive = solution41.firstMissingPositive(nums);
        System.out.println(firstMissingPositive);
    }
}
