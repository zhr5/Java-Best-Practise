package com.javaedge.algorithm.leetcode.binarytree;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        Solution98 solution98 = new Solution98();
        System.out.println(solution98.isValidBST(root));
    }
}
