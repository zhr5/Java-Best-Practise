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

    /**
     * 将矩阵中包含零的行和列全部设置为零
     *
     * @param matrix 一个二维整数数组，代表待处理的矩阵
     */
    public void setZeroes(int[][] matrix) {
        // 获取矩阵的行数和列数
        int m = matrix.length, n = matrix[0].length;

        // 初始化行标记数组，用于记录哪些行需要被设置为零
        boolean[] row = new boolean[m];
        // 初始化列标记数组，用于记录哪些列需要被设置为零
        boolean[] col = new boolean[n];

        // 第一次遍历矩阵，记录需要被设置为零的行和列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当发现元素为零时，标记对应的行和列为true
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        // 第二次遍历矩阵，根据标记数组将相应行和列的元素设置为零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前元素所在的行或列被标记为true，则将该元素设置为零
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 将矩阵中出现0的行和列全部设置为0
     *
     * @param matrix 二维整数数组，代表待处理的矩阵
     */
    public void setZeroes1(int[][] matrix) {
        // 获取矩阵的行数和列数
        int m = matrix.length, n = matrix[0].length;
        // 定义标志变量，用于标记第一列和第一行是否包含0
        boolean flagCol0 = false, flagRow0 = false;

        // 检查第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }

        // 检查第一行是否有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }

        // 使用第一行和第一列作为标记，记录需要置零的行和列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 根据标记将相应的元素置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 如果第一列有0，则将第一列全部置零
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        // 如果第一行有0，则将第一行全部置零
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 将矩阵中出现0的行和列全部设置为0
     * 这个方法优化了空间复杂度，使用矩阵的第一行和第一列来记录其余行列中是否出现0
     * 特别处理第一列，使用flagCol0变量记录第一列是否最初包含0
     *
     * @param matrix 输入的二维整数矩阵
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;

        // 第一遍扫描，使用第一行和第一列记录需要置零的信息
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

        // 第二遍处理，根据第一行和第一列的信息，将对应行列置零
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // 根据flagCol0的值决定是否将第一列置零
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

}
