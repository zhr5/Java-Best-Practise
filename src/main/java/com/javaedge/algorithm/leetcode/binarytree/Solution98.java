package com.javaedge.algorithm.leetcode.binarytree;

public class Solution98 {
    /**
     * 判断二叉树是否是有效的二叉搜索树（BST）
     * @param root 二叉树的根节点
     * @return 如果是有效的BST返回true，否则返回false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归辅助函数，检查当前子树是否满足BST的条件
     * @param root 当前子树的根节点
     * @param min 当前子树节点允许的最小值边界（不包含）
     * @param max 当前子树节点允许的最大值边界（不包含）
     * @return 当前子树满足BST条件返回true，否则返回false
     */
    public boolean helper(TreeNode root, long min, long max) {
        // 空节点视为合法BST，直接返回true
        if (root == null) {
            return true;
        }
        // 当前节点值未落在(min, max)区间内，说明违反BST定义
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 递归检查左子树和右子树：左子树所有节点必须小于当前节点值，右子树必须大于当前节点值
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

