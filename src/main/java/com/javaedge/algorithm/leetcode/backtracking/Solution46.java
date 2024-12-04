package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//全排列
//used数组去掉可以求组合问题,
//使用linkedlist是为了方便元素新增删除，常用于回溯、递归
public class Solution46 {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> tmp=new LinkedList<>();
    public List<List<Integer>>  premulist(int [] nums){
        boolean [] used =new boolean[nums.length];
        backtracking(nums,0,used);
        return res;

    }
    public void backtracking(int [] nums,int len,boolean [] used){
        if(len==nums.length){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                tmp.add(nums[i]);
                used[i]=true;
                backtracking(nums,len+1,used);
                used[i]=false;
                tmp.removeLast();
            }
        }
    }
    public static void main(String args[]){
        int [] nums=new int []{1,2,3};
        List<List<Integer>> res=new Solution46().premulist(nums);
        res.stream().forEach(System.out::print);
    }
}
