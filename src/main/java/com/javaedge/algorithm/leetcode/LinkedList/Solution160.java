package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution160 {
    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pa = headA , pb = headB;

        while(pa!=pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
/*        while(headA!=null&&headB!=null ){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
            if(headA==null) headA=headB;
            if(headB==null) headB=headA;
        }
        return null;*/
    }
}
