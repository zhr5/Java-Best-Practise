package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length,column=matrix[0].length;
        int i=row-1,j=0;
        while(i>=0&&j<=column-1){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]>target) {
                i--;
            }else{
                j++;
            }
        }
        return  false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        int low=0;
        int m=matrix.length;//行数
        int n=matrix[0].length;//列数
        int high=m*n-1;
        while (low<=high){
            int mid=(high-low)/2+low;//等同于（high+low)/2 防止溢出
            if(target==matrix[mid/n][mid%n]){
                return true;
            }else if(target>matrix[mid/n][mid%n]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
/*
    举个例子：
    假设一个 3x4 的矩阵（即 m=3, n=4）：

            [
            [1, 2, 3, 4],   // 行 0
            [5, 6, 7, 8],   // 行 1
            [9, 10, 11, 12] // 行 2
            ]
    DiffCopyInsert
    对于 mid 值 0 到 11：
    当 mid = 0，0%4 = 0（列索引为 0）。
    当 mid = 1，1%4 = 1（列索引为 1）。
    当 mid = 4（进入第二行），4%4 = 0（列索引为 0）。
    当 mid = 5，5%4 = 1（列索引为 1）。
    以此类推，模运算确保我们得到正确的列索引。
    因此，mid%n 确保了可以合理地将一维索引映射回二维数组的列索引。
    同理，mid/n 确保了可以合理地将一维索引映射回二维数组的行索引。*/

    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=3;
        Solution74 solution74=new Solution74();
        System.out.println(solution74.searchMatrix(matrix,target));
    }
}
