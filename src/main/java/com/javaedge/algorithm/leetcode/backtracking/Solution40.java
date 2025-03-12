package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    // 存储所有符合条件的组合
    List<List<Integer>> res = new ArrayList<>();
    // 存储当前探索的组合
    List<Integer> path = new ArrayList<>();

    /**
     * 寻找所有数字和为 target 的组合
     * @param candidates 候选数字数组
     * @param target 目标和
     * @return 所有符合条件的组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    /**
     * 回溯算法寻找所有数字和为 target 的组合
     * @param res 存储所有符合条件的组合
     * @param path 当前探索的组合
     * @param candidates 候选数字数组
     * @param target 目标和
     * @param sum 当前组合的数字和
     * @param idx 当前探索的起始索引
     */
    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum,
                             int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 去重逻辑：如果当前数字与前一个数字相同且不是本轮循环的第一个数字，则跳过
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target)
                break;
            path.add(candidates[i]);
            // 递归探索下一个数字，索引为 i+1，因为每个数字只能使用一次
            backtracking(res, path, candidates, target, sum + candidates[i], i+1);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution40 solution40 = new Solution40();
        List<List<Integer>> result = solution40.combinationSum2(candidates, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}

/*
输入: candidates = [10,1,2,7,6,1,5], target = 8,
        输出:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
        1 1 2 5 6 7 10
        */
