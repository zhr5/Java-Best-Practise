package com.javaedge.algorithm.leetcode.binarytree;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
