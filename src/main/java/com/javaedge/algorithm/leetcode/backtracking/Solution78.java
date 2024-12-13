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
 /*   List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            backtracking(nums, 0, i);
        }
        return res;
    }

    public void backtracking(int[] nums, int start, int end) {
        if (start > end) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= end; i++) {
            tmp.add(nums[i]);
            backtracking(nums, start + 1, end);
            tmp.removeLast();
        }
    }*/


    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
