package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution33 {
    //搜索旋转排序数组
    //leetcode地址：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {//左边有序
                if (nums[left] <= target && target < nums[mid]) {//在左边
                    right = mid - 1;
                } else {//在右边
                    left = mid + 1;
                }
            } else {//右边有序
                if (nums[mid] < target && target <= nums[right]) {//在右边
                    left = mid + 1;
                } else {//在左边
                    right = mid - 1;
                }
            }
        }
        return -1;    //未找到 target
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // 0
        int target = 0;
        Solution33 solution33 = new Solution33();
        int result = solution33.search(nums, target);
        System.out.println(result);
    }
}
