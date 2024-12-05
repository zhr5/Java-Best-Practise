package com.javaedge.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        //层序遍历从右往左,并且只加入第一个到结果
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len =q.size();
            int count=0;
            while(len-->0){
                TreeNode node=q.poll();
                if(count==0){
                    res.add(node.val);
                }
                count++;
                if(node.right!=null){
                    q.offer(node.right);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
            }
        }
        return res;
    }
}
