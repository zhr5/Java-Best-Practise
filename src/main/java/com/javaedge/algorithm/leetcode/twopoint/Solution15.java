package com.javaedge.algorithm.leetcode.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和  求三数之后等于0的三元组
/*输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]*/
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;//全大于0
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//跳过重复数字
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (sum < 0) {
                    while (l < r && nums[l] == nums[++l]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while (l < r && nums[r] == nums[--r]) ;
                    while (l < r && nums[l] == nums[++l]) ;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 提前终止
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复

            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) {
                    r--; // 先移动 r
                    while (l < r && nums[r] == nums[r + 1]) r--; // 跳过重复
                } else if (sum < target) {
                    l++; // 先移动 l
                    while (l < r && nums[l] == nums[l - 1]) l++; // 跳过重复
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    r--; // 先移动 r
                    l++; // 先移动 l
                    while (l < r && nums[r] == nums[r + 1]) r--; // 跳过重复
                    while (l < r && nums[l] == nums[l - 1]) l++; // 跳过重复
                }
            }
        }
        return res;
    }
    public static void main(String args[]) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution15 solution15 = new Solution15();
        solution15.threeSum(nums).stream().forEach(System.out::print);
    }
}
