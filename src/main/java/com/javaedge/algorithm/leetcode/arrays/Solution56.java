package com.javaedge.algorithm.leetcode.arrays;

//合并区间
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
        示例 1：
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        示例 2：
        输入：intervals = [[1,4],[4,5]]
        输出：[[1,5]]
        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) ->Integer.compare (o1[0] , o2[0]));//按nums[i][0]排序 o1=nums[i] o2=nums[i+1]
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);

    }
    public static void main(String args[]){
        int [] [] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [] [] res=merge(intervals);
        for(int [] interval:res){
            System.out.println(Arrays.toString(interval));
        }

    }
}
