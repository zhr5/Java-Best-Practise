package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }
/*    List<String> res = new ArrayList<>();
    char[] str;
    StringBuilder tmp = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        str = new char[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                str[i] = '(';
            } else {
                str[i] = ')';
            }
        }
        backtraking(str, 0);
        return res;
    }

    public void backtraking(char[] str, int start) {
        if (start == str.length) {
            if (isValid(tmp)) {
                res.add(new String(tmp));
            }
        }
        for (int i = start; i < str.length; i++) {
            tmp.append(str[i]);
            backtraking(str, start + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public boolean isValid(StringBuilder tmp) {
        if(tmp.length()%2!=0) return false;
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<tmp.length();i++){
            if(tmp.charAt(i)=='('){
                stack.push(tmp.charAt(i));
            }else{
                char c=stack.peek();
                if(c=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }*/
}
