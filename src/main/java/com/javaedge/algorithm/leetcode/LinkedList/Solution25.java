package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution25 {
    //k个一组反转链表
 /*   1 <= k <= n <= 5000
            0 <= Node.val <= 1000*/

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre= preHead;//记录每一组的前一个节点
        ListNode curr=head;//记录每一组的起始节点
        ListNode end=head;//记录每一组的最后一个节点
        while(curr!=null){
            end=curr;
            int i=1;
            while(i<k){
                end=end.next;
                if(end==null) return preHead.next;
                i++;
            }
            ListNode next=end.next;
            ListNode [] res=reverse(curr,end);
            pre.next=res[0];
            res[1].next=next;
            pre=res[1];
            curr=next;
        }
        return preHead.next;
    }
    public  ListNode [] reverse(ListNode start,ListNode end){
        ListNode pre=null;
        ListNode curr=start;
        while (curr!=end){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        curr.next=pre;
        return new ListNode []{end,start};
    }
}
