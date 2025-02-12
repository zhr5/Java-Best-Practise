package com.javaedge.algorithm.leetcode.greedyAlgorithm;

import java.util.Arrays;

public class Solution179 {
    /**
     * 将给定的整数数组转换为按照最大到最小的顺序排列的数字组成的字符串
     *
     * @param nums 整数数组
     * @return 按照最大到小的顺序排列的数字组成的字符串
     */
    public String largestNumber(int[] nums) {
        // 创建一个字符串数组来存储整数数组的字符串表示
        String[] strs = new String[nums.length];
        // 将整数数组转换为字符串数组
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        // 使用自定义的排序规则对字符串数组进行排序
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        // 如果排序后的第一个元素是"0"，则返回"0"
        if (strs[0].equals("0"))
            return "0";
        // 使用StringBuilder来构建最终的字符串结果
        StringBuilder res = new StringBuilder();
        // 将排序后的字符串数组元素添加到StringBuilder中
        for (String s : strs)
            res.append(s);
        // 返回构建好的字符串结果
        return res.toString();

    }
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Solution179 solution179 = new Solution179();
        String largestNumber = solution179.largestNumber(nums);
        System.out.println(largestNumber);
    }
}

/*
Arrays.sort(nums, (o1, o2) -> (o1).compareTo(o2));
表示按照整数的自然顺序对数组 nums 进行升序排序。具体来说，
它会比较两个整数 o1 和 o2 的大小，较小的整数排在前面，较大的整数排在后面。*/
