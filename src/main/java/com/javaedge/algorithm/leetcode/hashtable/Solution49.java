package com.javaedge.algorithm.leetcode.hashtable;

import java.util.*;

//字母异位词分组
/*输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]*/
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();//存放排序后的字符串和异位词分组的结果
        for(String str:strs){//一边遍历一边存放相同key的字符串
            char [] tmp =str.toCharArray();
            Arrays.sort(tmp);
            String key=new String(tmp);
            List<String> list=mp.getOrDefault(key,new ArrayList<>());
            list.add(str);
            mp.put(key,list);
        }

        return new ArrayList<>(mp.values());//通过values方法获取结果数组
    }
  /*  public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(String str:strs){
            char [] tmp =str.toCharArray();
            String key=new String(tmp);
            set.add(key);
        }
        for(String key:set){
            List<String> tmp=new ArrayList<>();
            for(String str:strs){
                char [] tmp1 =str.toCharArray();
                String key1=new String(tmp1);
                if(key1.equals(key)){
                    tmp.add(str);
                }
            }
            res.add(tmp);
        }
        return res;
    }*/

    public static void main(String args[]) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution49 solution49 = new Solution49();
        for (List<String> list : solution49.groupAnagrams(strs)) {
            System.out.println(list);
        }
    }
}
