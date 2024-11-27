package com.javaedge.algorithm.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    /*    使用哈希表的主要原因是提高查找效率。在这段代码中，哈希表 mp 用于存储数组中的元素及其索引，以便快速查找目标值 target - nums[i] 是否存在于数组中。具体来说：
        时间复杂度优化：如果不使用哈希表，通常需要两层嵌套循环来查找两个数的和是否等于目标值，时间复杂度为 O(n^2)。而使用哈希表可以在一次遍历中完成查找，时间复杂度降为 O(n)。
        空间换时间：虽然使用哈希表会增加额外的空间开销，但这种空间上的牺牲换取了时间上的显著提升，使得算法更加高效。*/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target - nums[i])) {
                return new int[]{i, mp.get(target - nums[i])};
            }
            mp.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Solution1().twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
