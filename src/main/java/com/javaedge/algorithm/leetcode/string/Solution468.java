package com.javaedge.algorithm.leetcode.string;

/**
 * Solution468类用于验证IP地址的合法性
 */
public class Solution468 {
    /**
     * 验证给定的IP地址是IPv4还是IPv6，或者都不是
     *
     * @param IP 待验证的IP地址字符串
     * @return 如果是有效的IPv4地址，返回"IPv4"；如果是有效的IPv6地址，返回"IPv6"；否则返回"Neither"
     */
    public String validIPAddress(String IP) {
        // 检查是否包含IPv4的特征字符'.'
        if (IP.indexOf('.') != -1) {
            return validateIPv4(IP);
        }
        // 检查是否包含IPv6的特征字符':'
        else if (IP.indexOf(':') != -1) {
            return validateIPv6(IP);
        }
        // 如果不包含上述特征字符，则既不是IPv4也不是IPv6
        return "Neither";
    }

    /**
     * 验证IPv4地址的合法性
     *
     * @param IP 待验证的IPv4地址字符串
     * @return 如果是有效的IPv4地址，返回"IPv4"；否则返回"Neither"
     */
    private String validateIPv4(String IP) {
        // 使用正则表达式去除多余的点并分割
        String[] split = IP.split("\\.", -1);
        // IPv4地址由4个部分组成
        if (split.length != 4) {
            return "Neither";
        }
        for (String s : split) {
            // 每个部分不能为空，不能超过3个字符，不能以0开头（除非是0本身）
            if (s.isEmpty() || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
                return "Neither";
            }
            // 每个字符必须是数字
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return "Neither";
                }
            }
            try {
                // 将每个部分转换为整数并检查范围
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                // 如果转换失败，则不是有效的IPv4地址
                return "Neither";
            }
        }
        // 所有检查通过，是有效的IPv4地址
        return "IPv4";
    }

    /**
     * 验证IPv6地址的合法性
     *
     * @param IP 待验证的IPv6地址字符串
     * @return 如果是有效的IPv6地址，返回"IPv6"；否则返回"Neither"
     */
    private String validateIPv6(String IP) {
        // 使用正则表达式去除多余的冒号并分割
        String[] split = IP.split(":", -1);
        // IPv6地址由8个部分组成
        if (split.length != 8) {
            return "Neither";
        }
        for (String s : split) {
            // 每个部分不能为空，不能超过4个字符
            if (s.isEmpty() || s.length() > 4) {
                return "Neither";
            }
            // 每个字符必须是0-9或a-f或A-F
            for (char c : s.toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return "Neither";
                }
            }
            try {
                // 将每个部分转换为十六进制数并检查范围
                int num = Integer.parseInt(s, 16);
                if (num < 0 || num > 65535) {// 十六进制数4位范围是0~65535
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                // 如果转换失败，则不是有效的IPv6地址
                return "Neither";
            }
        }
        // 所有检查通过，是有效的IPv6地址
        return "IPv6";
    }

    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String[] parts = ip.split("\\.");
        for (String part : parts) {
            System.out.println(part);
        }
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
