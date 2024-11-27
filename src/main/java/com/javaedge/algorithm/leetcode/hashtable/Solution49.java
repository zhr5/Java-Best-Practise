package com.javaedge.algorithm.leetcode.hashtable;

import java.util.*;

//字母异位词分组
/*输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]*/
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();//存放排序后的字符串和异位词分组的结果
        for(String str:strs){
            char [] tmp =str.toCharArray();
            Arrays.sort(tmp);
            String key=new String(tmp);
            List<String> list=mp.getOrDefault(key,new ArrayList<>());
            list.add(str);
            mp.put(key,list);
        }

        return new ArrayList<>(mp.values());
    }
    public static void main(String args[]) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution49 solution49 = new Solution49();
        for (List<String> list : solution49.groupAnagrams(strs)) {
            System.out.println(list);
        }
    }
}
