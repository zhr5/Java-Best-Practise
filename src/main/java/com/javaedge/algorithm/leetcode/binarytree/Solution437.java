package com.javaedge.algorithm.leetcode.binarytree;

//路径总和3
/**
 * Solution437类用于解决路径总和的问题
 * 它提供了一个方法来计算二叉树中所有路径的和等于给定值的路径总数
 */
public class Solution437 {
    /**
     * 计算二叉树中所有路径的和等于给定值的路径总数
     *
     * @param root 二叉树的根节点
     * @param sum 目标和值
     * @return 路径总数
     */
    public int pathSum(TreeNode root, long sum) {
        // 初始化结果变量
        int res = 0;
        // 如果根节点为空，直接返回结果
        if (root == null) return res;
        // 递归计算当前节点、左子树和右子树的路径总数
        res = dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    /**
     * 深度优先搜索（DFS）来计算从当前节点开始的路径总数
     *
     * @param node 当前节点
     * @param sum 剩余的和值
     * @return 从当前节点开始的路径总数
     */
    public int dfs(TreeNode node, long sum) {
        // 初始化结果变量
        int res = 0;
        // 如果当前节点为空，直接返回结果
        if (node == null) return res;
        // 如果当前节点的值等于剩余的和值，找到一条路径
        if (node.val == sum) res++;
        // 递归计算左子树和右子树的路径总数
        res += dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
        return res;
    }
}

