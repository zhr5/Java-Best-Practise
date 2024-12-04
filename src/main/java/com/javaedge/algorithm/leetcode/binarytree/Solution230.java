package com.javaedge.algorithm.leetcode.binarytree;

public class Solution230 {
    int res=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历
        count=k;
        inorder(root);
        return res;

    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        count--;
        if(count==0){
            res=root.val;
            return;
        }
        inorder(root.right);
    }
   /* int result,n;
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root==null) return ;
        traversal(root.left);
        if(n==0) return ;
        if(--n==0) result=root.val;
        traversal(root.right);

    }*/
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.left.left.left=new TreeNode(1);
        System.out.println(new Solution230().kthSmallest(root,3));
    }
}
