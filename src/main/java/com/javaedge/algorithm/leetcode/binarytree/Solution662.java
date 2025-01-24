package com.javaedge.algorithm.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution662 {
    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    /**
     * 计算二叉树的最大宽度
     * 宽度定义为二叉树每层节点的数目，求解的是所有层中节点数目最大的一层的宽度
     * 使用BFS（广度优先搜索）遍历树，同时记录每个节点的位置信息
     * 位置信息的计算方式为：根节点位置为1，左子节点位置为当前节点位置的2倍，右子节点位置为当前节点位置的2倍加1
     * 通过记录每层第一个非空节点和最后一个非空节点的位置，计算每层的宽度，并更新最大宽度
     *
     * @param root 二叉树的根节点
     * @return 返回二叉树的最大宽度
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1)); // 根节点的位置为1
        int max = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int begin = 0, end = 0;
            for (int i = 0; i < len; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (i == 0) begin = index; // 第一个非空节点的位置
                if (i == len - 1) end = index; // 最后一个非空节点的位置
                if (node.left != null) queue.offer(new Pair<>(node.left, index * 2)); // 左子节点位置为当前节点位置的2倍
                if (node.right != null) queue.offer(new Pair<>(node.right, index * 2 + 1)); // 右子节点位置为当前节点位置的2倍加1
            }
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }
/*    public int widthOfBinaryTree1(TreeNode root) {
        int max=0;
        Deque<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len=q.size();
            int begin=0,end=0;
            while(len-->0){
                TreeNode node=q.poll();
                if(node!=null){
                    if(begin==0){
                        begin++;
                        end++;
                    }else{
                        end++;
                    }
                }
                q.offer(node.left);
                q.offer(node.right);
            }
            max=Math.max(max,end-begin+1);
        }
        return  max;
    }*/
}
