package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution51 {
    //N皇后
/*    按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

    n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

    给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

    每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。*/
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char [] [] chess=new char [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j]='.';
            }
        }//初始化棋盘
        dfs(chess,0,n);
        return res;
    }
    public void dfs(char [] [] chess,int row,int n){//row表示当前行 0-n-1
        if(row==n){//到达最后一行
            res.add(convertToChess(chess));
            return;
        }
        for(int i=0;i<n;i++){
            if(check(chess,row,i)){
                chess[row][i]='Q';
                dfs(chess,row+1,n);
                chess[row][i]='.';
            }
        }
    }
    public boolean check(char [] [] chess,int row,int i){
        //同一列
        for(int r=row-1;r>=0;r--){
            if(chess[r][i]=='Q')
                return false;
        }
        //左斜线
        for(int r=row-1,c=i-1;r>=0&&c>=0;r--,c--){
            if(chess[r][c]=='Q')
                return false;
        }
        //右斜线
        for(int r=row-1,c=i+1;r>=0&&c<chess[0].length;r--,c++){
            if(chess[r][c]=='Q')
                return false;
        }
        return true;
    }
    public List<String> convertToChess(char [] [] chess){//将二维数组转化为一维数组
        ArrayList<String> res=new ArrayList<>();
        for(char [] s:chess){
            res.add(new String(s));
        }
        return res;
    }
}
