package com.javaedge.algorithm.dynamicProgramming;

import java.util.Arrays;

public class SmashingGoldenEggs {
    public static int getMaxEgg(int [] nums){
        int [] dp=new int[nums.length];//dp[i]表示以i结尾砸的连续金蛋的最大价值
        dp[0]=nums[0];
 /*       for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            System.out.print(" "+dp[i]);
        }

        System.out.println();*/
        int max=dp[0];
        for(int i=0;i<nums.length;i++){
            dp[i]=Math.max(dp[(i-1+nums.length)%nums.length]+nums[i],nums[i]);
            max=Math.max(dp[i],max);
            System.out.print(" "+dp[i]);
        }
        System.out.println();
        return max;

    }

    public static void main(String args[]){
        int [] nums =new int []{3,-1,2,-1};
        System.out.println();
        System.out.println(getMaxEgg(nums));
    }
}
