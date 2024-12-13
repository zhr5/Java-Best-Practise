package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    //17. 电话号码的字母组合
    Map<Character, String> mp = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }

    };
    List<String> res = new ArrayList<>();
    StringBuffer tmp=new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;
        backtrack(mp,digits,0);
        return  res;

    }
    public void backtrack( Map<Character, String> phoneMap, String digits, int index) {
        if (index == digits.length()) {
            res.add(tmp.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                tmp.append(letters.charAt(i));
                backtrack(phoneMap, digits, index + 1);
                tmp.deleteCharAt(index);
            }
        }
    }
}
