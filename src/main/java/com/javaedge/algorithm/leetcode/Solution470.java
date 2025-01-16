package com.javaedge.algorithm.leetcode;

import static java.lang.Thread.sleep;

public class Solution470 {
    public int rand7(){
        return (int) (Math.random() % 7 + 1);
    }
    /**
     * 生成一个1到10之间的随机数
     *
     * 此方法通过多次调用rand7()方法来生成一个1到10之间的随机数
     * 选择1到10之间的数字是为了扩展随机性的范围，尽管最终结果是基于7的倍数
     *
     * @param  调用rand7()方法的次数，间接影响最终随机数的生成范围
     * @return 1到10之间的随机数
     */
    public int rand10(int n) {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
    public static void main(String[] args) {
        Solution470 solution470 = new Solution470();
        for (int i = 0; i < 10; i++) {
            System.out.println(solution470.rand10(i));
        }
    }
}
