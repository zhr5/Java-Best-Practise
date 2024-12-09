package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode PreHead = new ListNode(0);
        PreHead.next = head;
        ListNode first = PreHead;
        ListNode second = PreHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return PreHead.next;
    }
}
