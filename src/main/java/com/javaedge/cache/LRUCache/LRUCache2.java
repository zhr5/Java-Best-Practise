package com.javaedge.cache.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    public class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }
    /*双向链表节点*/

    /*哈希表定义*/
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    /*key--node*/
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache2(int capacity) {
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            //如果key不存在，创建一个新节点
            DLinkedNode newNode=new DLinkedNode(key,value);
            //添加到哈希表
            cache.put(key,newNode);
            //添加到双向链表头部
            addToHead(newNode);
            if(cache.size()>capacity){
                //若超出容量，删除双向链表尾部节点，并拿到删除的key去哈希表删除
                DLinkedNode tail=removeTail();
                //删除哈希表对应的项
                cache.remove(tail.key);
            }
        }else{
            //如果key存在，先通过哈希表定位，再修改value，并移动到头部
            node.value=value;
            moveToHead(node);
        }
    }

    /*
     * 1.新增元素的操作--加入链表头部，若超过容量淘汰链表尾部
     * 所以需要方法
     * 1.移动某元素到头部=(删除该元素+新增元素到头部)
     * 2.新增元素到头部 插入链表头节点后面的位置
     * 3.尾部删除=(删除该元素+返回删除的值)
     * 4.从链表中删除某元素 引用还在只是链表中没了(任意位置--这时候由于是双向链表所以可以在O(1)时间完成)
     * */
    private  void moveToHead(DLinkedNode node){
        //1-从链表中删除
        node.prev.next=node.next;
        node.next.prev=node.prev;
        //2-移动到链表头节点后面
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;

    }

    private void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        //从链表中删除
        res.prev.next=res.next;
        res.next.prev=res.prev;

        return res;
    }
}
