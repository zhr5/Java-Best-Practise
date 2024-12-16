package com.javaedge.algorithm.leetcode.graph;

public class Solution994 {
    //腐烂的橘子
    int res = 0;
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int row = grid.length, column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    int count = 0;
                    dfs(grid, i, j, count);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ) return;
        if( grid[i][j]==1){
            count++;
            res=Math.max(res,count);
        }
        grid[i][j] = 0;
        dfs(grid, i, j + 1, count + 1);
        dfs(grid, i, j - 1, count + 1);
        dfs(grid, i - 1, j, count + 1);
        dfs(grid, i + 1, j, count + 1);
    }
}
