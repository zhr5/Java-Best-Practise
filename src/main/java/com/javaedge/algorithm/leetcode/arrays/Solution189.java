package com.javaedge.algorithm.leetcode.arrays;

public class Solution189 {
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        myrotate(nums,0,nums.length-k-1);
        myrotate(nums,nums.length-k,nums.length-1);
        myrotate(nums,0,nums.length-1);

    }
    public static void myrotate(int[] nums,int start,int end){
        while(start<end){
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
