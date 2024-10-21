package com.javaedge.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的定义：
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//二叉树层序遍历
class Solution102 {
    public  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);

        //TreeNode node=q.getFirst();

        while(!q.isEmpty()){
            List<Integer> tmp =new ArrayList<Integer>();
            int n=q.size();
            while(n-->0){
                TreeNode node=q.poll();
                tmp.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


    public static void main(String args[]){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        Solution102 s=new Solution102();

        List<List<Integer>> res=s.levelOrder(node1);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j));
            }
        }

    }
}
