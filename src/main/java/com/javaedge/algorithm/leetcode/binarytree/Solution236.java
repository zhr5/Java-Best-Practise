package com.javaedge.algorithm.leetcode.binarytree;

public class Solution236 {
    //1. p q都能找到 返回最近公共祖先 2. p q 找到一个，返回p q 3. 都没找到 返回null
    //通过递归的方式，逐层向下查找 p 和 q，并根据查找结果来确定最近公共祖先的位置。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Solution236 solution236 = new Solution236();
        System.out.println(solution236.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
