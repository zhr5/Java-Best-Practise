package com.javaedge.algorithm.leetcode;

public class Solution521 {
    public static int findLUSlength(String a, String b) {
        if(isSubStr(a,  b)){
            return -1;
        }else{
            return a.length()>b.length() ? a.length():b.length();
        }
    }
    public static  boolean isSubStr(String a, String b){
        if(a.length()!=b.length()) return false;
        int i=0,j=0;
        while(i<a.length()&&j<b.length()){
            return a.charAt(i++)==b.charAt(j++);
        }
        return true;
    }

    public static void main(String args[]){
        
    }
}
