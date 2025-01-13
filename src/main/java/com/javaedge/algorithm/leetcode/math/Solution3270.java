package com.javaedge.algorithm.leetcode.math;

public class Solution3270 {
    public int generateKey(int num1, int num2, int num3) {
        int res=0;
        int tmp=1000;
        for(int i=0;i<4;i++){
            //res+=res*10+Math.min(Math.min(num1/tmp,num2/tmp),num3/tmp);  // 错误的写法  res重复计算
            // 正确的写法：先计算出最小的数，然后乘以相应的位数，再加到 res 上
            res=res*10+Math.min(Math.min(num1/tmp,num2/tmp),num3/tmp);;
            num1%=tmp;
            num2%=tmp;
            num3%=tmp;
            tmp/=10;
        }
        return res;
    }
}

/*

       num1 = 1234
        num2 = 2345
        num3 = 3456
               res = 0
               tmp = 1000
               num1 / tmp = 1, num2 / tmp = 2, num3 / tmp = 3
               minDigit = Math.min(Math.min(1, 2), 3) = 1
               res += res * 10 + minDigit = 0 + 0 * 10 + 1 = 1
               num1 %= tmp = 1234 % 1000 = 234
               num2 %= tmp = 2345 % 1000 = 345
               num3 %= tmp = 3456 % 1000 = 456
               tmp /= 10 = 1000 / 10 = 100
               第二次迭代 (i = 1):

               res = 1
               tmp = 100
               num1 / tmp = 2, num2 / tmp = 3, num3 / tmp = 4
               minDigit = Math.min(Math.min(2, 3), 4) = 2
               res += res * 10 + minDigit = 1 + 1 * 10 + 2 = 13
               num1 %= tmp = 234 % 100 = 34
               num2 %= tmp = 345 % 100 = 45
               num3 %= tmp = 456 % 100 = 56
               tmp /= 10 = 100 / 10 = 10
               第三次迭代 (i = 2):

               res = 13
               tmp = 10
               num1 / tmp = 3, num2 / tmp = 4, num3 / tmp = 5
               minDigit = Math.min(Math.min(3, 4), 5) = 3
               res += res * 10 + minDigit = 13 + 13 * 10 + 3 = 143
               num1 %= tmp = 34 % 10 = 4
               num2 %= tmp = 45 % 10 = 5
               num3 %= tmp = 56 % 10 = 6
               tmp /= 10 = 10 / 10 = 1
               第四次迭代 (i = 3):

               res = 143
               tmp = 1
               num1 / tmp = 4, num2 / tmp = 5, num3 / tmp = 6
               minDigit = Math.min(Math.min(4, 5), 6) = 4
               res += res * 10 + minDigit = 143 + 143 * 10 + 4 = 1573
               num1 %= tmp = 4 % 1 = 0
               num2 %= tmp = 5 % 1 = 0
               num3 %= tmp = 6 % 1 = 0
               tmp /= 10 = 1 / 10 = 0 (注意：tmp 变成了 0，但不影响本次迭代)*/
