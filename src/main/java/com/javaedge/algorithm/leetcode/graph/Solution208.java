package com.javaedge.algorithm.leetcode.graph;

public class Solution208 {
    class Trie {
        /**
         * Trie树的子节点数组，每个节点最多有26个子节点，对应英文字母a-z
         */
        private Trie[] children;

        /**
         * 表示当前节点是否构成一个完整的单词
         */
        private boolean isEnd;

        /**
         * Trie树节点的构造方法
         * 初始化子节点数组和结束标志
         */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * 向Trie树中插入一个单词
         *
         * @param word 要插入的单词，由小写字母组成
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /**
         * 在Trie树中搜索一个完整的单词
         *
         * @param word 要搜索的单词
         * @return 如果找到完整的单词则返回true，否则返回false
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * 搜索Trie树中是否有以给定前缀开头的单词
         *
         * @param prefix 要搜索的前缀
         * @return 如果找到以prefix为前缀的单词则返回true，否则返回false
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        /**
         * 辅助函数，用于搜索给定前缀对应的节点
         *
         * @param prefix 要搜索的前缀
         * @return 返回对应前缀的节点，如果前缀不存在则返回null
         */
        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
    public static void main(String[] args) {
        Trie trie = new Solution208().new Trie();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
        trie.insert("apricot");
        trie.insert("grape");
        trie.insert("pear");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("banana")); // true
        System.out.println(trie.search("orange")); // true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

