package com.javaedge.algorithm.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.isComplete(root));
    }
}
