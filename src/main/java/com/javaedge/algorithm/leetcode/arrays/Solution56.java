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
    /**
     * 合并区间
     * 给定一个区间的集合，合并所有重叠的区间
     *
     * @param intervals 一个二维数组，每个一维数组表示一个区间，其中包含两个整数，分别是区间的起始和结束位置
     * @return 返回一个二维数组，包含所有合并后的区间
     */
    public static int[][] merge(int[][] intervals) {
        // 创建一个列表用于存储合并后的区间
        List<int[]> res = new ArrayList<>();

        // 对区间进行排序，确保区间的起始位置按照升序排列
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 初始化第一个区间的起始位置
        int start = intervals[0][0];

        // 遍历排序后的区间
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的起始位置大于前一个区间的结束位置，说明它们不重叠，可以添加前一个区间到结果列表中
            if (intervals[i][0] > intervals[i - 1][1]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                // 更新当前区间的起始位置为新的起始点
                start = intervals[i][0];
            } else {
                // 如果当前区间与前一个区间重叠，更新当前区间的结束位置为两个区间结束位置中较大的一个
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        // 将最后一个区间添加到结果列表中
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        // 将结果列表转换为二维数组并返回
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
