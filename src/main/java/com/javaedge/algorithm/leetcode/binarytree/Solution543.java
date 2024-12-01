package com.javaedge.algorithm.leetcode.binarytree;

public class Solution543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
