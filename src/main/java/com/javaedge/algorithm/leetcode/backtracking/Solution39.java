package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. 组合总和
public class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序,
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum,
                             int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}


/*
在这段代码中，对 candidates 数组进行排序的主要目的是为了优化回溯过程，减少不必要的计算和重复组合的生成。具体来说，排序有以下几个好处：
提前终止遍历：在回溯过程中，如果当前的 sum + candidates[i] 已经大于 target，则可以直接终止后续的遍历。因为数组已经排序，后续的元素只会更大，不可能再找到满足条件的组合。
避免重复组合：排序后，相同的元素会相邻出现，可以在回溯过程中更容易地跳过重复的组合，从而提高算法的效率。*/

/*为什么从 idx 开始
 在 backtracking 方法中，参数 idx 表示当前搜索的起始索引。从 idx 开始的原因主要有以下几点：
 避免重复组合：通过从 idx 开始，可以确保每个元素在当前组合中只被使用一次或多次（根据题目要求），从而避免生成重复的组合。例如，如果 candidates 是 [2, 3, 6, 7]，
 并且 target 是 7，从 idx 开始可以确保不会生成 [2, 2, 3] 和 [2, 3, 2] 这样的重复组合。
 优化搜索过程：从 idx 开始可以减少不必要的递归调用。因为已经排序过的数组，后续的元素只会更大，如果当前元素已经不满足条件，后续的元素也不可能满足条件，从而可以提前终止遍历。*/
