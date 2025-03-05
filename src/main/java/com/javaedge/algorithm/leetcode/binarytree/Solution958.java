package com.javaedge.algorithm.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node == null) {
                flag = false;
            } else {
                // 如果在非空节点前出现了空节点那么则为false
                if (!flag) {
                    return false;
                }
                deque.addFirst(node.left);
                deque.addFirst(node.right);
            }
        }
        return true;
    }

}
