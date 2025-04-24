package com.javaedge.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    // 114. 二叉树展开为链表

    //O(n)空间复杂度
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    public void flatten1(TreeNode root) {//递归
        if (root == null) return;

        // 递归展开左子树和右子树
        flatten1(root.left);
        flatten1(root.right);

        // 保存当前节点的右子树
        TreeNode rightTree = root.right;
        // 将左子树接到右子树的位置
        root.right = root.left;
        // 左子树置空
        root.left = null;

        // 找到当前右子树（原左子树）的最后一个节点，连接原右子树
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = rightTree;
    }
    public void flatten2(TreeNode root) {//与3一样
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }

        }
    }
    //左子树的前序访问的最后一个节点接到根节点的右指针上，需先暂存右指针
    //左子树的前序访问的最后一个节点怎么找
    public void flatten4(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;//找右子树的pre
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;//上面的操作会不断把右子树嫁接到左子树的最右节点，且最后把左子树接到右指针
        }
    }


  public static void main(String[] args) {
      Solution114 solution114 = new Solution114();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.right = new TreeNode(6);
      solution114.flatten(root);
  }
}
