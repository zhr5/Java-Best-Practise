package com.javaedge.algorithm.leetcode;

//剑指03- 0-n的数组中的重复数字
public class SolutionJz03 {
    public static int findRepNum(int nums[]){
        //把数组中的数字放到相等标的位置上
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i) continue;
            else{
                if(nums[i]==nums[nums[i]]) return nums[i];//说明i已经放到nums[i]一次后又有一个i的值
                int tmp=nums[i];//把i放到nums[i]的位置上
                nums[i]=nums[tmp];
                nums[tmp]=tmp;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int [] nums =new int []{1,3,2,0,3,5,3};
        System.out.println(findRepNum(nums));
    }
}
