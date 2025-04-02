package com.javaedge.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树中序遍历
public class Solution94 {
    /*left-root-right*/
    List<Integer> res=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }
    /**
     * 使用栈实现二叉树的中序遍历
     *
     * @param root 二叉树的根节点，遍历的起始位置
     * @return 包含中序遍历结果的整数列表，按访问顺序存储节点值
     */
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        // 循环处理当前节点或栈中未处理的父节点
        while (root != null || !stk.isEmpty()) {
            // 遍历到当前子树的最左叶子节点，路径节点全部入栈
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            // 弹出栈顶节点作为当前访问节点，记录节点值
            root = stk.pop();
            res.add(root.val);

            // 转向处理右子树（若存在右子树，在下个循环会处理其左子树链）
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
