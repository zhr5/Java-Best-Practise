package com.javaedge.collection.priorityqueue;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueApplication {
    public static void main(String[] args){
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> o2-o1);//大根堆
        pq.add(1);
        pq.add(2);
        //方法引用
        Stream.of(pq).forEach(System.out::println);
    }
}
