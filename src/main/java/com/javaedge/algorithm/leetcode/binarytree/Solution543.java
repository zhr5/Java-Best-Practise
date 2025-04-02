package com.javaedge.algorithm.leetcode.binarytree;

public class Solution543 {
    private int max = 0;

    /**
     * 计算二叉树的直径（最长路径长度）
     * @param root 二叉树的根节点
     * @return 返回二叉树的最大直径（边数）
     * 方法说明：通过深度优先搜索遍历二叉树，在后序遍历过程中更新最大直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    /**
     * 递归计算二叉子树深度并更新最大直径
     * @param root 当前遍历的子树根节点
     * @return 返回当前子树的最大深度（边数）
     * 实现逻辑：
     * 1. 递归终止条件：空节点返回深度0
     * 2. 后序遍历计算左右子树深度
     * 3. 关键路径更新：当前节点的直径=左子树深度+右子树深度
     * 4. 返回当前子树的最大深度用于父节点计算
     */
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        // 递归计算左右子树深度
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        // 更新最大直径：当前节点的左右子树深度之和构成潜在最大路径
        max = Math.max(max, leftDepth + rightDepth);

        // 返回当前子树深度（取较大子树深度+1）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

