package com.javaedge.algorithm.leetcode.binarytree;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode A,TreeNode B){
        if(A==null&&B==null) return true;
        if(A==null||B==null) return false;
        if(A.val!=B.val) return false;
        return dfs(A.left,B.right)&&dfs(A.right,B.left);
    }
}
