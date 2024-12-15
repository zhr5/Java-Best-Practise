package com.javaedge.algorithm.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution53 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix[0].length,n=matrix.length;
        int l=0,r=m-1,t=0,b=n-1;//左、右、上、下边界
        int count=0;
        while(count<m*n){
            //从左到右
            for(int i=l;i<=r&&count<m*n;i++){
                res.add(matrix[t][i]);
                count++;
            }
            t++;
            //从上到下
            for(int i=t;i<=b&&count<m*n;i++){
                res.add(matrix[i][r]);
                count++;
            }
            r--;
            //从右到左
            for(int i=r;i>=l&&count<m*n;i--){
                res.add(matrix[b][i]);
                count++;
            }
            b--;
            //从下到上
            for(int i=b;i>=t&&count<m*n;i--){
                res.add(matrix[i][l]);
                count++;
            }
            l++;
        }

        return res;
    }

}
