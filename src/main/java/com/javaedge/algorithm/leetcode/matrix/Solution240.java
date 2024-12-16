package com.javaedge.algorithm.leetcode.matrix;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length,column=matrix[0].length;
        int i=row-1,j=0;
        while(i>=0&&j<column){
            if(target==matrix[i][j]){
                return true;
            }if(target>matrix[i][j]){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
