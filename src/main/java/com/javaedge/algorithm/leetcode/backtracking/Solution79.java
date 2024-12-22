package com.javaedge.algorithm.leetcode.backtracking;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return res;
    }

    boolean res = false;
    public boolean exist1(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backTracking(board, word, i, j, 0);
                    if(res){
                        return res;
                    }
                }
            }
        }
        return false;
    }

    public void backTracking(char[][] board, String word, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||start>=word.length()|| board[i][j]!=word.charAt(start)){
            return ;
        }
        if (start == word.length()-1) {
            res=true;
            return ;
        }
        char tmp=board[i][j];
        board[i][j]=' ';
        backTracking(board,word,i+1,j,start+1);
        backTracking(board,word,i-1,j,start+1);
        backTracking(board,word,i,j+1,start+1);
        backTracking(board,word,i,j-1,start+1);
        board[i][j]=tmp;
        return;
    }
}
