package com.javaedge.algorithm.leetcode.matrix;

public class Solution73 {
    // 73. Set Matrix Zeroes
    // https://leetcode-cn.com/problems/set-matrix-zeroes/
    // 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

    // 示例 1:
    // 输入:
    // [
    //   [1,1,1],
    //   [1,0,1],
    //   [1,1,1]
    // ]
    // 输出:
    // [
    //   [1,0,1],
    //   [0,0,0],
    //   [1,0,1]
    // ]

    // 示例 2:
    // 输入:
    // [
    //   [0,1,2,0],
    //   [3,4,5,2],
    //   [1,3,1,5]
    // ]
    // 输出:
    // [
    //   [0,0,0,0],
    //   [0,4,5,0],
    //   [0,3,1,0]
    // ]

    // 进阶:
    // 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
    // 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。

/*   时间复杂度：O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。我们至多只需要遍历该矩阵两次。
    空间复杂度：O(m+n)，其中 m 是矩阵的行数，n 是矩阵的列数。我们需要分别记录每一行或每一列是否有零出现。*/

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

}
