package com.javaedge.algorithm.datastructures;

import java.util.*;

public class binaryTree {

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if(root==null) return null;
        List<List<Integer>> res =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> tmp =new ArrayList<>();
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root==null) return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    //非递归
    public List<Integer> preorderTraversal1(TreeNode root) {

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root==null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root==null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
    public static void main(String[] args) {
/*
                 1
           2           3
        4    5     6       7
*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        binaryTree bt = new binaryTree();

        // 使用 stream 输出二维 ArrayList
        bt.levelOrderTraversal(root).stream() .forEach(list -> {
            list.stream().forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });

        bt.preorderTraversal(root).stream().forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        bt.inorderTraversal(root).stream().forEach(System.out::print);
        System.out.println();
        bt.postorderTraversal(root).stream().forEach(System.out::print);
    }
}
