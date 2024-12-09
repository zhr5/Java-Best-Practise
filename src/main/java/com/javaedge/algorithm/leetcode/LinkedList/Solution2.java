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
    //和21题类似，只是多了一个carry变量来记录进位
    //时间复杂度O(max(m,n))，空间复杂度O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode curr = preHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return preHead.next;
    }

}
