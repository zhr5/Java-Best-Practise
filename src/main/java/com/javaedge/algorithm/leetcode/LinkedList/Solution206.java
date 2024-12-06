package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution206 {
    //反转链表
   /* 1->2->3->4*/
    //头插法 遍历把节点插入到虚拟头节点后面
    public ListNode reverseList(ListNode head) {
        ListNode pHead=new ListNode(0);
        while(head!=null){
            ListNode next=head.next;
            head.next=pHead.next;
            pHead.next=head;
            head=next;
        }
        return pHead.next;
    }
    //迭代法 遍历不断把指针逆向
    public ListNode reverseList1(ListNode head) {
        ListNode prev=null;//指向上一个遍历的节点
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
