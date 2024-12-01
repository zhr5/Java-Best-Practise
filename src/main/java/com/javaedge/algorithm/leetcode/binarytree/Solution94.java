package com.javaedge.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树中序遍历
public class Solution94 {
    /*left-root-right*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root==null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution94 solution94 = new Solution94();
        solution94.inorderTraversal(root);
    }
}
