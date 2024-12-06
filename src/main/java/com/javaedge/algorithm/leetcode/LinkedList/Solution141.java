package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution141 {
    //环形链表
 /*   public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&slow.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }*/
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode low = head, fast = head.next;
        while (low != null && fast != null && fast.next != null) {
            if (low == fast) {
                return true;
            } else {
                low = low.next;
                fast = fast.next.next;
            }
        }
        return false;
    }
}
