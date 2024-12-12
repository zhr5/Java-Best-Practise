package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    //子集
/*    示例 1：
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    示例 2：
    输入：nums = [0]
    输出：[[],[0]]*/
    List<List<Integer>> res =new ArrayList<>();
    List<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return  res;
    }

    public void backtracking(int[] nums,int start){
        if(start==nums.length){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            
        }
    }
}
