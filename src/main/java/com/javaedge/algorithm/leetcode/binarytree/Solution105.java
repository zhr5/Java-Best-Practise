package com.javaedge.algorithm.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    //从前序和中序建立二叉树
    Map<Integer,Integer> mp=new HashMap<>();//记录中序遍历节点与下标的关系
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return mybuildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode mybuildTree(int[] preorder, int[] inorder,int pStart,int pEnd,int iStart,int iEnd){
        if(pStart>pEnd) return null;
        TreeNode root=new TreeNode(preorder[pStart]);
        int index=mp.get(preorder[pStart]);
        int leftTreeLen=index-iStart;
        root.left=mybuildTree(preorder,inorder,pStart+1,pStart+leftTreeLen,iStart,index-1);
        root.right=mybuildTree(preorder,inorder,pStart+1+leftTreeLen,pEnd,index+1,iEnd);
        return root;
    }
}
