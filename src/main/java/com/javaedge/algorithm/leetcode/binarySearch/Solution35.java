package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution35 {
    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    // 请必须使用时间复杂度为 O(log n) 的算法。
    // 示例 1:
    // 输入: nums = [1,3,5,6], target = 5
    // 输出: 2
/*    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=r-l/2+l;
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }*/
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {//如果查不到值，需走l=mid+1,将target插入到右边位置，如【1，3】 target=2,需将target插入到index=(0+1)/2 +1
            int mid = (r - l) / 2 + l;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
