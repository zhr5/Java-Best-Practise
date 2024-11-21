package com.javaedge.algorithm.leetcode.slidingWindow;

import org.apache.tools.ant.taskdefs.Tar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//最小覆盖子串
public class Solution76 {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) {
                cnt++;
            }
            while (cnt == m && hash[chars[j]] > 0) {// cnt 等于 t 的长度 m 时，说明当前窗口包含了 t 中所有字符,尝试收缩窗口
                hash[chars[j++]]--;
            }
            if (cnt == m) {
                if (res.equals("") || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }
    public String minWindow1(String s, String t) {
        int m=s.length(),n=t.length();
        Map<Character,Integer> TargetMapCount= new HashMap<>();
        for(char c:t.toCharArray()){
            TargetMapCount.put(c,TargetMapCount.getOrDefault(c,0)-1);
        }
        int l=0,r=0,matched=0;
        int [] resIndex = new int [] {0,0};
        //先向右移动窗口得到有效子串，再左移收缩窗口优化
        while(r<m){
            if(r<m&&TargetMapCount.containsKey(s.charAt(r))){
                TargetMapCount.put(s.charAt(r),TargetMapCount.get(s.charAt(r))+1);
                if(TargetMapCount.get(s.charAt(r))<=0){//说明匹配完一个字符s.charAt(r),即使字符重复
                    matched++;
                }
            }
            r++;
            //尝试收缩窗口
            while(matched==n){
                if(resIndex[1]-resIndex[0]==0||r-l < resIndex[1]-resIndex[0]){
                    resIndex[0]=l;
                    resIndex[1]=r;//本来应该是r-1，但是后面使用subString方法左闭右开
                }

                if(l<m&&TargetMapCount.containsKey(s.charAt(l))){
                    TargetMapCount.put(s.charAt(l), TargetMapCount.get(s.charAt(l))-1);//左移要把已匹配的s.charAt(l)还原
                    if(TargetMapCount.get(s.charAt(l)) > 0){ //s.charAt(l)匹配不完了 试试AABBC  ABC
                        matched--;
                    }
                }
                l++;
            }

        }
        return s.substring(resIndex[0],resIndex[1]);

    }

    public static void main(String[] args) {
/*        String s = "ADOBECODEBANC";
        String t = "ABC";*/
        String s = "AA";
        String t = "AA";
        String res = new Solution76().minWindow1(s, t);
        System.out.println(res);
    }
}
