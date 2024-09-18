package com.javaedge.algorithm.leetcode;

import java.util.Arrays;

public class Solution63 {
    /*
    * 答案正确
    * */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int [][] dp=new int [m][n];
        for(int i=0;i<m&&obstacleGrid[i][0]==0;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n&&obstacleGrid[0][i]==0;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }


    /*
    * 答案错误
    * */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int [] [] dp=new int [m][n];//表示机器人到dp[i][j]共存在的路径数
        //表示机器人到dp[i][j]共存在的路径数
        //dp[i][j]=dp[i-1][j]+dp[i][j-1]
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==0)//差别在这里，如果存在障碍物，那么这个方向上就不存在路径可以通到终点了，如果不取&&的话障碍物后面的路径点还是会计算
                dp[0][j]=1;
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0)
                dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        int[][] obstacleGrid =new int [][]{ {0,0},
                                            {1,1},
                                            {0,0} };
        uniquePathsWithObstacles(obstacleGrid);
        uniquePathsWithObstacles1(obstacleGrid);
    }

}
