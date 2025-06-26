package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution33 {
    //搜索旋转排序数组
    //leetcode地址：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    /**
     * 在旋转排序数组中搜索目标值
     *
     * @param nums 旋转排序后的数组
     * @param target 需要搜索的目标值
     * @return 目标值在数组中的索引，如果不存在则返回 -1
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断左边是否有序
            if (nums[left] <= nums[mid]) {
                // 如果目标值在左边有序数组中
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 如果目标值在右边有序数组中
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;    // 未找到 target
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // 0
        int target = 0;
        Solution33 solution33 = new Solution33();
        int result = solution33.search(nums, target);
        System.out.println(result);
    }
}
