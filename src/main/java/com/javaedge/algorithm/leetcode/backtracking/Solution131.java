package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    List<List<String>> res=new ArrayList<>();
    LinkedList<String> tmp=new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0,new StringBuilder());
        return res;
    }

    public void backtracking(String s,int start,StringBuilder sb){
        if(start==s.length()){
            //注意创建一个新的copy
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=start;i<s.length();i++){
            sb.append(s.charAt(i));
            if (check(sb)){
                tmp.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                tmp.removeLast();
            }
        }

    }

    //helper method, 检查是否是回文
    private boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length()/ 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){return false;}
        }
        return true;
    }
}
