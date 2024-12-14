package com.javaedge.algorithm.leetcode.trick;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
    public int singleNumber1(int[] nums) {
        int x = 0;
        for (int num : nums) // 1. 遍历 nums 执行异或运算
        {
            x ^= num;// 1. 异或运算
        }
        return x; // 2. 返回出现一次的数字 x
    }
/*    基本性质
    相同位异或为0：对于任何整数 a 和 b，a ^ a = 0。
    不同位异或为1：a ^ b = 1 当且仅当 a 和 b 的对应位不同。
    与0异或不变：a ^ 0 = a。
    交换律和结合律：这意味着 a ^ b = b ^ a 和 (a ^ b) ^ c = a ^ (b ^ c)。
    0 ^ 1 =1
    */
}
