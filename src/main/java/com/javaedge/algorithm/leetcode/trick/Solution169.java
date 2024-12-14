package com.javaedge.algorithm.leetcode.trick;

public class Solution169 {
    //摩尔投票算法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }

    public int majorityElement1(int[] nums) {
        int count=1;
        int tmp=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==tmp){
                count++;
            }else{
                count--;
                if(count<0){
                    tmp=nums[i];
                    count=1;
                }
            }
        }
        return tmp;
    }
}
