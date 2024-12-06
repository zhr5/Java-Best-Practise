package com.javaedge.algorithm.leetcode.binarytree;

public class Solution124 {
    //二叉树最大路径和
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumDfs(root);
        return maxSum;
    }

    public int maxSumDfs(TreeNode node) {
        if (node == null) return 0;
        int leftMax = Math.max(maxSumDfs(node.left), 0);
        int rightMax = Math.max(maxSumDfs(node.right), 0);

        int nodeSum = node.val + leftMax + rightMax;
        //若以当前节点为根节点计算的最大路径和大于之前的maxSum，则替换它
        maxSum = Math.max(maxSum, nodeSum);

        return node.val + Math.max(leftMax, rightMax);
    }
}
