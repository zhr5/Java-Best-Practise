package com.javaedge.algorithm.leetcode.graph;

import java.util.*;

public class Solution994 {
    //腐烂的橘子
    public int orangesRotting(int[][] grid) {
        //网格的行数
        int row = grid.length;
        //网格的列数
        int column = grid[0].length;
        //队列，用于存储腐烂的橘子的坐标
        Queue<int[]> queue = new LinkedList<>();

        //count 表示新鲜橘子的数量
        int count = 0;
        //遍历网格，统计新鲜橘子的数量和腐烂橘子的初始位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //如果当前单元格是新鲜橘子
                if (grid[i][j] == 1) {
                    count++;
                }
                //如果当前单元格是腐烂橘子
                else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        //round 表示腐烂的轮数，或者分钟数
        int round = 0;
        //当还有新鲜橘子且队列不为空时，进行腐烂传播
        while (count > 0 && !queue.isEmpty()) {
            round++;
            //当前轮数需要处理的腐烂橘子数量
            int n = queue.size();
            //遍历当前所有腐烂的橘子，使它们向四周传播腐烂
            for (int i = 0; i < n; i++) {
                //取出队列中的腐烂橘子坐标
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                //检查四个方向是否有新鲜橘子，如果有，则将其腐烂，并加入队列
                if (r-1 >= 0 && grid[r-1][c] == 1) {// 上
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < row && grid[r+1][c] == 1) {// 下
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {// 左
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < column && grid[r][c+1] == 1) {// 右
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        //如果还有新鲜橘子，则返回-1，表示所有橘子不能被腐烂完
        if (count > 0) {
            return -1;
        }
        //否则返回腐烂的轮数
        else {
            return round;
        }
    }

    //时间复杂度：O(MN)，其中 M 和 N 分别是矩阵的行数和列数。
    //空间复杂度：O(MN)，队列中的元素个数最多为 MN。
}

