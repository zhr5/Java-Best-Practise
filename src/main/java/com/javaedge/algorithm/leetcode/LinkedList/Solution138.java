package com.javaedge.algorithm.leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    //随机链表的复制
/*    0 <= n <= 1000
     -104 <= Node.val <= 104
    Node.random 为 null 或指向链表中的节点。*/
/*    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node preHead=new Node(0);
        Node node=new Node(head.val);
        preHead.next=node;
        Node curr=head.next;
        while (curr!=null){
            node.next=new Node(curr.val);
            node=node.next;
            curr=curr.next;
        }
         curr=head;
        while (curr!=null){

        }
    }*/
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);

    }
}
