package com.javaedge.algorithm.leetcode.LinkedList;

public class Solution2 {
    //两数之和
 /* 输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.
    示例 2：
    输入：l1 = [0], l2 = [0]
    输出：[0]
    示例 3：
    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]                    9999999
    输出：[8,9,9,9,0,0,0,1]                                          9999
                                                                 10009998
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode preHead=new ListNode(0);
        ListNode p1=reverseList1(l1),p2=reverseList1(l2);
        ListNode p3=null;
        while(p1!=null||p2!=null){
            int sum=(p1.val+p2.val+carry);
            if(preHead.next==null){
                p3=new ListNode(sum);
                preHead.next=p3;
            }
            carry=sum/10;
            p3=p3.next;
            p1=p1.next;
            p2=p2.next;
        }
        if(p1==null){
            p2.val+=carry;
            p3.next=p2;
        }
        if(p2==null){
            p1.val+=carry;
        }


    }
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
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int in=0;
        ListNode head=null,tail=null;
        while(l1!=null||l2!=null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + in;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            in = sum/10;
            if(l1!=null){
                l1=l1.next;
            }

            if(l2!=null){
                l2=l2.next;
            }
        }
        if(in>0){
            tail.next = new ListNode(in);
        }

        return head;
    }
}

}
