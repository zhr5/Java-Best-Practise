package com.javaedge.algorithm.leetcode.slidingWindow;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//找到字符串中的所有字母异位词
public class Solution438 {
    public List<Integer> findAnagrams(String s,String p){
        Set<Character> set=p.chars().mapToObj(c->(char) c).collect(Collectors.toSet());
        System.out.println(set);
        return null;
    }
    public static void main(String args[]){
        String s="";
        String p="abc";
        Set<Character> set=p.chars().mapToObj(c->(char) c).collect(Collectors.toSet());
        System.out.println(set);
    }
}
