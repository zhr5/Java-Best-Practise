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
        ListNode fast = head.next, slow = head;//fast从head.next开始，slow从head开始是为了让slow刚好在中间节点的前缀
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //使用快慢指针将链表分成两个子链表
        ListNode tmp = slow.next;//保存后半段链表的头节点
        slow.next = null;//断开后半段链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);//虚拟头节点   从这里开始和21题一样
        ListNode curr = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = left != null ? left : right;//另一个链表可能还有剩余节点未处理
        return h.next;
    }
}
