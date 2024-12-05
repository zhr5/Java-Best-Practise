package com.javaedge.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int tag = 1;// 表示从左到右
        while (!dq.isEmpty()) {
            int len = dq.size();
            List<Integer> tmp = new LinkedList<>();
            tag = -tag;
            while (len-- > 0) {
                TreeNode node = dq.poll();
                if(tag<0){
                    tmp.add(node.val);
                }else{
                    tmp.add(0,node.val);// 链表头插
                }
                if (node.left != null) {
                    dq.offer(node.left);
                }
                if (node.right != null) {
                    dq.offer(node.right);
                }

            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

}
