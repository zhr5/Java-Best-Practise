package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;//此时node1已经交换到下一组的的前一个节点了
        }
        return preHead.next;
    }

}
