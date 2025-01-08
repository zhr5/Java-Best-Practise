package com.javaedge.algorithm.leetcode.twoPoint;

public class Solution4 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。**/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            nums[k] = nums2[j];
            j++;
            k++;
        }
        if ((m + n) % 2 == 0) {
            return ((double)nums[(m + n) / 2 - 1] + nums[(m + n) / 2]) / 2;
        } else {
            return nums[(m + n) / 2];
        }
    }
    // 时间复杂度分析：
    // 算法的主要操作是合并两个数组，合并的过程需要 O(m+n) 的时间，而合并的过程又可以分为两个部分，
    // 第一部分是将 nums1 和 nums2 合并，第二部分是计算中位数，所以时间复杂度是 O(m+n)。
    // 由于合并的过程是线性的，所以时间复杂度是 O(m+n)。
    // 而计算中位数的过程是 O(1)，所以时间复杂度是 O(1)。
    // 综上，算法的时间复杂度是 O(m+n)。

}
