package com.javaedge.algorithm.leetcode.binarytree;

public class Solution124 {
    // 二叉树最大路径和
    // 初始化为最小整数，以处理所有节点值都为负数的情况
    int maxSum = Integer.MIN_VALUE;

    /**
     * 计算二叉树中的最大路径和
     * @param root 二叉树的根节点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        // 调用深度优先搜索函数来计算最大路径和
        maxSumDfs(root);
        // 返回计算出的最大路径和
        return maxSum;
    }

    /**
     * 深度优先搜索，计算经过当前节点的最大路径和，并更新全局最大路径和
     * @param node 当前节点
     * @return 当前节点及其一侧子树的最大路径和（用于父节点计算）
     */
    public int maxSumDfs(TreeNode node) {
        // 如果当前节点为空，返回0
        if (node == null) return 0;
        // 递归计算左子树的最大路径和，如果为负数，则不考虑（取0）
        int leftMax = Math.max(maxSumDfs(node.left), 0);
        // 递归计算右子树的最大路径和，如果为负数，则不考虑（取0）
        int rightMax = Math.max(maxSumDfs(node.right), 0);

        // 计算以当前节点为根节点的最大路径和
        int nodeSum = node.val + leftMax + rightMax;
        // 如果以当前节点为根节点计算的最大路径和大于之前的maxSum，则替换它
        maxSum = Math.max(maxSum, nodeSum);

        // 返回当前节点及其一侧子树的最大路径和，供父节点计算使用
        // 只选择较大的一侧，因为路径不能有分叉
        return node.val + Math.max(leftMax, rightMax);
    }
}

