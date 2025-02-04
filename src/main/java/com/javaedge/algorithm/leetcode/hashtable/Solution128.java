package com.javaedge.algorithm.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

//最长连续子序列
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
/*不断寻找连续子序列的起始数字,不符合的跳过,保证每个数字只被处理一次*/
public class Solution128 {
    /**
     * 计算数组中最长连续序列的长度
     *
     * @param nums 输入的整数数组
     * @return 返回最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        // 如果数组为空，则直接返回0
        if(nums.length==0) return 0;

        // 使用HashSet存储数组中的所有数字，以实现快速查找
        Set<Integer> set =new HashSet<>();
        for (int n:nums){
            set.add(n);
        }

        // 初始化最长连续序列的长度为0
        int max=0;
        for(int n:set){//set去重了，所以不用判断重复
            // 如果当前数字的前一个数字不在set中，说明它可能是一个连续序列的起始数字
            if(!set.contains(n-1)){
                int curr=n;
                int currmax=1;
                // 检查当前数字后面是否还有连续的数字，并更新当前连续序列的长度
                while(set.contains(curr+1)){
                    curr++;
                    currmax++;
                }
                // 更新最长连续序列的长度
                max=Math.max(max,currmax);
            }
        }
        // 返回最长连续序列的长度
        return max;
    }
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};// 1-2-3-4 ->4
        Solution128 solution128=new Solution128();
        System.out.println(solution128.longestConsecutive(nums));
    }
}
