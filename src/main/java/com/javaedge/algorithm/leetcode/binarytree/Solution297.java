package com.javaedge.algorithm.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {

  /**
 * 将二叉树编码为单个字符串。
 *
 * @param root 二叉树的根节点
 * @return 编码后的字符串表示
 */
public String serialize(TreeNode root) {
    // 如果根节点为空，返回空数组表示
    if (root == null)
        return "[]";

    // 使用StringBuilder构建最终的字符串
    StringBuilder res = new StringBuilder("[");

    // 使用队列辅助进行层次遍历
    Queue<TreeNode> queue = new LinkedList<TreeNode>() {
        {
            add(root);
        }
    };

    // 层次遍历二叉树
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();

        // 如果当前节点不为空，追加其值并将其左右子节点加入队列
        if (node != null) {
            res.append(node.val + ",");
            queue.add(node.left);
            queue.add(node.right);
        } else {
            // 如果当前节点为空，追加"null"表示
            res.append("null,");
        }
    }

    // 删除最后一个逗号并关闭数组
    res.deleteCharAt(res.length() - 1);
    res.append("]");

    return res.toString();
}

/**
 * 将字符串解码为二叉树。
 *
 * @param data 编码后的字符串表示
 * @return 解码后的二叉树根节点
 */
public TreeNode deserialize(String data) {
    // 如果字符串表示为空数组，返回null
    if (data.equals("[]"))
        return null;

    // 分割字符串以获取节点值数组
    String[] vals = data.substring(1, data.length() - 1).split(",");

    // 使用第一个值创建根节点
    TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

    // 使用队列辅助构建二叉树
    Queue<TreeNode> queue = new LinkedList<TreeNode>() {
        {
            add(root);
        }
    };

    int i = 1;

    // 遍历队列以构建二叉树
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();

        // 如果当前值不是"null"，创建左子节点并将其加入队列
        if (!vals[i].equals("null")) {
            node.left = new TreeNode(Integer.parseInt(vals[i]));
            queue.add(node.left);
        }
        i++;

        // 如果下一个值不是"null"，创建右子节点并将其加入队列
        if (!vals[i].equals("null")) {
            node.right = new TreeNode(Integer.parseInt(vals[i]));
            queue.add(node.right);
        }
        i++;
    }

    // 返回构建的二叉树根节点
    return root;
}

}
