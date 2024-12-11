package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution148 {
    //排序链表
/*    输入：head = [4,2,1,3]
    输出：[1,2,3,4]*/
/*    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);
        while (head != null) {

        }
    }*/
    //归并排序-链表版
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left != null ? left : right;//另一个链表可能还有剩余节点未处理
        return res.next;
    }
}
