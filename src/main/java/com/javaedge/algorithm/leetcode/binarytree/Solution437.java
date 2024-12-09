package com.javaedge.algorithm.leetcode.binarytree;

//路径总和3
public class Solution437 {
    /*root = [1,-2,-3,1,3,-2,null,-1]
    targetSum =-1*/
    /*    public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            return mypathSum(root, targetSum) + (root.left == null ? 0 : pathSum(root.left, targetSum))
                    + (root.right == null ? 0 : pathSum(root.right, targetSum));
        }

        public int mypathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            if (root.val == targetSum) return 1;
            return mypathSum(root.left, targetSum - root.val) + mypathSum(root.right, targetSum - root.val);
        }*/
    public int pathSum(TreeNode root, long sum) {
        int res=0;
        if(root==null) return res;
        res=dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return res;
    }
    public int dfs(TreeNode node, long sum){
        int res=0;
        if(node==null) return res;
        if(node.val==sum) res++;
        res+=dfs(node.left,sum-node.val)+dfs(node.right,sum-node.val);
        return res;
    }
}
