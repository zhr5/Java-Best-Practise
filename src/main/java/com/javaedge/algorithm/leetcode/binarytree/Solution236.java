package com.javaedge.algorithm.leetcode.binarytree;

public class Solution236 {
    //1. p q都能找到 返回最近公共祖先 2. p q 找到一个，返回p q 3. 都没找到 返回null
    //通过递归的方式，逐层向下查找 p 和 q，并根据查找结果来确定最近公共祖先的位置。
   /* 求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从底向上的遍历方式。

    在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。

    要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。*/
    /**
     * 寻找二叉树中两个节点的最近公共祖先
     * 该方法通过递归的方式，逐层向下查找 p 和 q，并根据查找结果来确定最近公共祖先的位置
     *
     * @param root 二叉树的根节点
     * @param p 第一个节点
     * @param q 第二个节点
     * @return 最近公共祖先的节点，如果不存在则返回null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空或者是要查找的节点之一，则返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 在左子树中查找 p 和 q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中查找 p 和 q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树中没有找到 p 或 q，则返回右子树中的查找结果
        if (left == null) {
            return right;
        }
        // 如果右子树中没有找到 p 或 q，则返回左子树中的查找结果
        if (right == null) {
            return left;
        }
        // 如果 p 和 q 分别在左右子树中找到，则当前节点是最近公共祖先
        return root;//在两侧子树
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
