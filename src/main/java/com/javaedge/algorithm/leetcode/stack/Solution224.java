package com.javaedge.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution224 {
    public int calculate(String s) {
        int res=0;
        int sign=1;
        int len=s.length();
        Deque<Integer> stack =new ArrayDeque<>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int num=c-'0';
                while(i+1<len&&Character.isDigit(s.charAt(i+1))){
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                res+=sign*num;
            }else if(c=='+'||c=='-'){
                sign= c=='+'? 1:-1;
            }else if(c=='('){
                stack.push(res);
                stack.push(sign);
                sign=1;
                res=0;
            }else if(c==')'){
                res=res*stack.pop()+stack.pop();
            }
        }
        return res;
    }
}
