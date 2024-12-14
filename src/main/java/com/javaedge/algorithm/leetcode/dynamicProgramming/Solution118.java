package com.javaedge.algorithm.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
/*    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        // 假设当前是row行,column列 nums[i][j]=nums[i-1][j-1]+nums[i-1][j] (0<j<column-1)
        int[][] nums = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            nums[0][i] = 1;
            nums[i][i] = 1;
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
            }
        }

        for (int[] innerArray : nums) {
            List<Integer> innerList = new ArrayList<>();
            for (int num : innerArray) {
                innerList.add(num); // 将每个 int 添加到内层 List 中
            }
            res.add(innerList); // 将内层 List 添加到外层 List 中
        }
        return res;
    }*/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    innerList.add(1); // 每行的首尾元素都是1
                } else {
                    int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    innerList.add(val); // 计算中间的元素
                }
            }
            res.add(innerList); // 将内层 List 添加到外层 List 中
        }
        return res;
    }
}
