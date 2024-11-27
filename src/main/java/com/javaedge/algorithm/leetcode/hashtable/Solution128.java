package com.javaedge.algorithm.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

//最长连续子序列
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
/*不断寻找连续子序列的起始数字,不符合的跳过,保证每个数字只被处理一次*/
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set =new HashSet<>();
        for (int n:nums){
            set.add(n);
        }
        int max=0;
        for(int n:set){
            if(!set.contains(n-1)){
                int curr=n;
                int currmax=1;
                while(set.contains(curr+1)){
                    curr++;
                    currmax++;
                }
                max=Math.max(max,currmax);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};// 1-2-3-4 ->4
        Solution128 solution128=new Solution128();
        System.out.println(solution128.longestConsecutive(nums));
    }
}
