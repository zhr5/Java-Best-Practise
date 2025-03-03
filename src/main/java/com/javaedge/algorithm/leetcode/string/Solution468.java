package com.javaedge.algorithm.leetcode.string;

public class Solution468 {
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') != -1) {
            return validateIPv4(IP);
        } else if (IP.indexOf(':') != -1) {
            return validateIPv6(IP);
        }
        return "Neither";
    }

    private String validateIPv4(String IP) {
        // 使用正则表达式去除多余的点并分割
        String[] split = IP.split("\\.", -1);
        if (split.length != 4) {
            return "Neither";
        }
        for (String s : split) {
            if (s.isEmpty() || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
                return "Neither";
            }
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return "Neither";
                }
            }
            try {
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validateIPv6(String IP) {
        // 使用正则表达式去除多余的冒号并分割
        String[] split = IP.split(":", -1);
        if (split.length != 8) {
            return "Neither";
        }
        for (String s : split) {
            if (s.isEmpty() || s.length() > 4) {
                return "Neither";
            }
            for (char c : s.toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return "Neither";
                }
            }
            try {
                int num = Integer.parseInt(s, 16);
                if (num < 0 || num > 65535) {// 十六进制数4位范围是0~65535
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv6";
    }
}

/*
.：表示任意单个字符（除了换行符）。要匹配实际的点号，需使用\\.
        *：表示前一个字符出现0次或多次
        +：表示前一个字符出现1次或多次
        ?：表示前一个字符出现0次或1次
        ^：表示字符串的开始位置
        $：表示字符串的结束位置
        { 和 }：用于指定前面字符的数量
        [ 和 ]：用于定义字符集
        ( 和 )：用于分组
        |：表示逻辑或
        \：用于转义，本身也需要被转义为\\\\*/
