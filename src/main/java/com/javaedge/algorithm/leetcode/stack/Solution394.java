package com.javaedge.algorithm.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Solution394 {
  public String decodeString(String s) {
    StringBuilder res = new StringBuilder(); // 用于存储最终结果
    int multi = 0; // 当前的重复次数
    LinkedList<Integer> stack_multi = new LinkedList<>(); // 存储重复次数的栈
    LinkedList<String> stack_res = new LinkedList<>(); // 存储当前结果的栈

    // 遍历输入字符串的每一个字符
    for(Character c : s.toCharArray()) {
        if(c == '[') { // 遇到 '[' 时，表示开始一个新的重复段
            stack_multi.addLast(multi); // 将当前的重复次数入栈
            stack_res.addLast(res.toString()); // 将当前的结果字符串入栈
            multi = 0; // 重置重复次数
            res = new StringBuilder(); // 重置结果字符串
        }
        else if(c == ']') { // 遇到 ']' 时，表示结束当前的重复段
            StringBuilder tmp = new StringBuilder(); // 创建一个临时字符串用于存储重复的内容
            int cur_multi = stack_multi.removeLast(); // 从栈中取出当前的重复次数
            // 根据当前的重复次数，将结果重复并存入临时字符串
            for(int i = 0; i < cur_multi; i++) tmp.append(res);
            // 将之前的结果与重复的结果组合，并更新结果字符串
            res = new StringBuilder(stack_res.removeLast() + tmp);
        }
        else if(c >= '0' && c <= '9') { // 如果字符是数字
            // 更新当前的重复次数
            multi = multi * 10 + Integer.parseInt(c + ""); // 注意字符转换为数字 可以用String.valueOf()代替
        }
        else { // 其他字符则直接添加到结果字符串中
            res.append(c); // 不在 '[]' 中的字符，直接添加到结果中
        }
    }
    return res.toString(); // 返回最终解码的字符串
}

   public String decodeString1(String s) {
    // 从字符串的起始位置调用深度优先搜索（DFS）
    return dfs(s, 0)[0];
}

private String[] dfs(String s, int i) {
    StringBuilder res = new StringBuilder(); // 用于存储解析后的结果
    int multi = 0; // 用于存储当前的重复次数

    while (i < s.length()) { // 遍历整个字符串
        // 如果字符是数字，更新重复次数
        if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
            multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));

        // 如果遇到左括号，表示要开始解析子串
        else if (s.charAt(i) == '[') {
            String[] tmp = dfs(s, i + 1); // 递归解析子串
            i = Integer.parseInt(tmp[0]); // 更新当前索引位置到子串结束的位置
            // 根据重复次数将解析出的子串追加到结果中
            while (multi > 0) {
                res.append(tmp[1]);
                multi--;
            }
        }

        // 如果遇到右括号，返回当前位置和当前结果
        else if (s.charAt(i) == ']')
            return new String[] { String.valueOf(i), res.toString() };

        // 否则，将当前字符追加到结果中
        else
            res.append(String.valueOf(s.charAt(i)));

        i++; // 移动到下一个字符
    }
    // 返回结果（最终解析的字符串）
    return new String[] { res.toString() };
}


  public String decodeString2(String s) {
    // 创建一个字符队列，用于存储字符串中的每个字符
    Queue<Character> q = new LinkedList<>();
    // 将字符串的每个字符加入队列
    for (char c : s.toCharArray()) {
        q.offer(c);
    }
    // 调用 decodeString 方法进行解码
    return decodeString(q);
}

public String decodeString(Queue<Character> q) {
    StringBuilder res = new StringBuilder(); // 用于存储最终的解码结果
    int num = 0; // 用于存储当前的数字（重复次数）

    // 当队列不为空时循环处理
    while (!q.isEmpty()) {
        char c = q.poll(); // 从队列中取出一个字符
        // 如果字符是数字
        if (c >= '0' && c <= '9') {
            // 计算当前数字
            num = 10 * num + (c - '0');
        }
        // 如果字符是 '['，表示一个新的块的开始
        else if (c == '[') {
            // 递归调用解码方法获取内部重复的字符串
            String tmp = decodeString(q);
            // 将内部字符串添加到结果中，重复 num 次
            while (num > 0) {
                res.append(tmp);
                num--;
            }
        }
        // 如果字符是 ']', 返回当前结果
        else if (c == ']') {
            return res.toString();
        }
        // 处理其他字符，直接添加到结果中
        else {
            res.append(c);
        }
    }
    // 返回最终解码的结果
    return res.toString();
}

    public static void main(String[] args) {
        Solution394 solution = new Solution394();
        String s = "3[a]2[bc]";
        System.out.println(solution.decodeString(s)); // "aaabcbc"
        System.out.println(solution.decodeString1(s)); // "aaabcbc"
    }
}