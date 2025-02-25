package com.javaedge.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU（Least Frequently Used）缓存实现类
 * 该缓存根据数据的访问频率来决定哪些数据应该被移除
 * 当缓存达到容量上限时，访问频率最低的数据将被移除
 * 如果存在多个访问频率相同的数据，则移除其中最早未访问的数据
 */
class LFUCache {
    // 缓存容量
    private final int capacity;
    // 键到值的映射
    private final Map<Integer, Integer> keyToValue;
    // 键到访问频率的映射
    private final Map<Integer, Integer> keyToFreq;
    // 访问频率到键的集合的映射，用于高效地按频率分组管理键
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 当前最低访问频率
    private int minFreq;

    /**
     * 构造函数，初始化LFU缓存
     * @param capacity 缓存的容量，必须为非负数
     */
    public LFUCache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
    }

    /**
     * 获取指定键的值
     * 如果键不存在，则返回-1
     * 否则，更新该键的访问频率，并返回对应的值
     * @param key 要获取值的键
     * @return 键对应的值，如果键不存在则返回-1
     */
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }

    /**
     * 插入或更新指定键的值
     * 如果缓存容量为0，则不进行任何操作
     * 如果键已存在，则更新其值并增加访问频率
     * 如果键不存在且缓存已满，则移除访问频率最低的项，然后插入新项
     * @param key 要插入或更新的键
     * @param value 键对应的值
     */
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }
        if (keyToValue.size() >= capacity) {
            removeMinFreqKey();
        }
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    /**
     * 增加指定键的访问频率
     * 更新键的访问频率，并维护访问频率到键的集合的映射
     * 如果当前频率的键集合为空，则移除该频率的映射
     * @param key 要增加访问频率的键
     */
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
    }

    /**
     * 移除访问频率最低的项
     * 从访问频率最低的键集合中移除一个键，并更新相关映射
     */
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
        int evictKey = keys.iterator().next();
        keys.remove(evictKey);
        if (keys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToValue.remove(evictKey);
        keyToFreq.remove(evictKey);
    }
}

