package com.javaedge.algorithm.leetcode.binarytree;

public class Solution101 {
    /**
     * 判断二叉树是否轴对称
     * @param root 二叉树的根节点
     * @return true表示树是轴对称的，false表示不对称
     */
    public boolean isSymmetric(TreeNode root) {
        // 空树默认对称。非空树时检查左右子树的镜像对称性
        if(root==null) return true;
        return dfs(root.left,root.right);
    }

    /**
     * 递归检查两个子树是否镜像对称
     * @param A 左子树当前比较节点（或右子树镜像比较节点）
     * @param B 右子树当前比较节点（或左子树镜像比较节点）
     * @return true表示当前子树满足镜像对称要求
     */
    public boolean dfs(TreeNode A,TreeNode B){
        // 同时为空说明结构相同
        if(A==null&&B==null) return true;
        // 仅单边为空说明结构不对称
        if(A==null||B==null) return false;
        // 值不相等直接返回false
        if(A.val!=B.val) return false;

        // 递归检查：A的左子树与B的右子树对称，且A的右子树与B的左子树对称
        return dfs(A.left,B.right)&&dfs(A.right,B.left);
    }
}

