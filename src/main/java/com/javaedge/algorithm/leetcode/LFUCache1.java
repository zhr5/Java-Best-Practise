package com.javaedge.algorithm.leetcode;

// 基于PriorityQueue
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache1 {

    // 缓存容量
    private final int capacity;
    // 用于存储键值对
    private final Map<Integer, Integer> keyValueMap;
    // 用于存储每个键的访问频率
    private final Map<Integer, Integer> frequencyMap;
    // 优先队列，用于按照访问频率和插入顺序排序节点
    private final PriorityQueue<Node> priorityQueue;

    // 内部节点类，用于存储键、值以及访问频率信息
    private static class Node implements Comparable<Node> {
        int key;
        int value;
        int frequency;

        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            // 先按照访问频率排序，如果频率相同，按照插入顺序（这里通过键来间接表示）排序
            if (this.frequency!= other.frequency) {
                return Integer.compare(this.frequency, other.frequency);
            }
            return Integer.compare(this.key, other.key);
        }
    }

    public LFUCache1(int capacity) {
        this.capacity = capacity;
        this.keyValueMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>();
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }

        // 获取当前键的访问频率并更新
        int frequency = frequencyMap.get(key);
        frequencyMap.put(key, frequency + 1);

        // 更新优先队列中的节点信息
        Node node = new Node(key, keyValueMap.get(key), frequency + 1);
        priorityQueue.remove(new Node(key, 0, frequency));
        priorityQueue.add(node);

        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            // 调用get方法来更新访问频率等相关操作
            get(key);
            return;
        }

        if (keyValueMap.size() >= capacity) {
            // 移除访问频率最低且最久未使用的键值对
            Node evictNode = priorityQueue.poll();
            keyValueMap.remove(evictNode.key);
            frequencyMap.remove(evictNode.key);
        }

        // 添加新的键值对到缓存
        keyValueMap.put(key, value);
        frequencyMap.put(key, 1);
        priorityQueue.add(new Node(key, value, 1));
    }
}
