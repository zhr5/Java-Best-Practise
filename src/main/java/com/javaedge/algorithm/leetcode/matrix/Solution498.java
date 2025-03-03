package com.javaedge.algorithm.leetcode.matrix;

public class Solution498 {
/*    public int[] findDiagonalOrder(int[][] mat) {
        // 向右上 i-- j++ 到边界 i>=0 i<=mat.length-1 下一步 i+1
        // 向左下 i++ j-- 到边界 j>=0 j<=mat[0].length-1 下一步 j+1
        // 终止 i= mat.length-1 j=mat[0].length-1
        int i = 0, j = 0;
        int[] res = new int[mat.length * mat[0].length];
        int cnt = 0;
        while (i <= mat.length - 1 && j <= mat[0].length - 1) {
            // 向右上
            while (i >= 0 && i <= mat.length - 1) {
                res[cnt++] = mat[i][j];
                i--;
                j++;
            }
            i++;
            // 向左下
            while (j >= 0 && j <= mat[0].length - 1) {
                res[cnt++] = mat[i][j];
                j--;
                i++;
            }
            j++;
        }
        return res;
    }*/
    /**
     * 对二维数组进行对角线遍历
     *
     * @param mat 一个二维整数数组
     * @return 返回遍历后的数组
     */
    public int[] findDiagonalOrder(int[][] mat) {
        // 检查输入数组是否为空或长度为0
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        // 获取二维数组的行数和列数
        int rows = mat.length;
        int cols = mat[0].length;

        // 创建结果数组，用于存储遍历后的结果
        int[] res = new int[rows * cols];
        // 初始化计数器，用于记录当前遍历到的结果数组的索引
        int cnt = 0;

        // 初始化起始位置
        int i = 0, j = 0;
        // 定义一个布尔变量，用于判断当前遍历方向是向上还是向下
        boolean goingUp = true;

        // 遍历二维数组
        for (int k = 0; k < rows * cols; k++) {
            // 将当前遍历到的元素存入结果数组
            res[cnt++] = mat[i][j];

            // 根据当前遍历方向，更新i和j的值
            if (goingUp) {
                // 当遍历到最右侧列时，向下移动一行，并改变遍历方向
                if (j == cols - 1) {
                    i++;
                    goingUp = false;
                }
                // 当遍历到最上侧行时，向右移动一列，并改变遍历方向
                else if (i == 0) {
                    j++;
                    goingUp = false;
                }
                // 否则，继续沿对角线向上遍历
                else {
                    i--;
                    j++;
                }
            } else {
                // 当遍历到最下侧行时，向右移动一列，并改变遍历方向
                if (i == rows - 1) {
                    j++;
                    goingUp = true;
                }
                // 当遍历到最左侧列时，向下移动一行，并改变遍历方向
                else if (j == 0) {
                    i++;
                    goingUp = true;
                }
                // 否则，继续沿对角线向下遍历
                else {
                    i++;
                    j--;
                }
            }
        }

        // 返回遍历后的结果数组
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution498 solution498 = new Solution498();
        int[] res = solution498.findDiagonalOrder(mat);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
