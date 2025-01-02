package com.javaedge.algorithm.leetcode.trick;

/*整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

        例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
        类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
        而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
        给你一个整数数组 nums ，找出 nums 的下一个排列。*/
        // 123465 -> 123546
public class Solution31 {
    public void nextPermutation(int[] nums) {
        // 找到下一个排列
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {// 找到第一个升序的元素
            i--;
        }
        if (i >= 0) {// 找到第一个升序的元素后，找到第一个大于nums[i]的元素
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {// 找到第一个大于nums[i]的元素
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);// 反转升序部分 // 反转是为了得到字典序中下一个排列
    }

    private void swap(int[] nums, int i, int j) {
        // 交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        // 反转数组中从start到end的部分
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
