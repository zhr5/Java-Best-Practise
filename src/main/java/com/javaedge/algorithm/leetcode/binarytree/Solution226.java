package com.javaedge.algorithm.leetcode.binarytree;

public class Solution226 {
    /**
     * 翻转二叉树（镜像二叉树）
     * 采用递归方式遍历每个节点，交换其左右子节点
     *
     * @param root 二叉树的根节点
     * @return TreeNode 翻转后的二叉树根节点
     * 递归终止条件：当节点为null时直接返回
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;

        // 交换当前节点的左右子节点
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        // 递归处理左右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
