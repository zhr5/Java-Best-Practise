package com.javaedge.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

//通过前序和中序遍历列表重建二叉树
public class SolutionJz07 {
    /**
      Definition for a binary tree node.**/
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    Map<Integer,Integer> mp=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //缓存inorder中
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return reContructTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode reContructTree(int[] preorder, int[] inorder,int pstart,int pend,int instart,int inend)
    {
        if(pend>pstart) return null;
        return null;
    }

}
