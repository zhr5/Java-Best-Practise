package com.javaedge.algorithm.leetcode.dynamicProgramming;

/*给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组
        （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
        测试用例的答案是一个 32-位 整数。
        示例 1:
        输入: nums = [2,3,-2,4]
        输出: 6
        解释: 子数组 [2,3] 有最大乘积 6。
        示例 2:
        输入: nums = [-2,0,-1]
        输出: 0
        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
        提示:
        1 <= nums.length <= 2 * 104
        -10 <= nums[i] <= 10
        nums 的任何子数组的乘积都 保证 是一个 32-位 整数*/
public class Solution152 {

/*    遍历数组时计算当前最大值，不断更新
    令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
    由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
    当负数出现时则imax与imin进行交换再进行下一步计算
    时间复杂度：O(n)

    作者：画手大鹏
    链接：https://leetcode.cn/problems/maximum-product-subarray/solutions/7561/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    /**
     * 找出数组中乘积最大的非空连续子数组，并返回该子数组所对应的乘积
     * @param nums 整数数组
     * @return 乘积最大的连续子数组的乘积值
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        // 遍历数组，计算以每个元素结尾的子数组的最大和最小乘积
        for(int i=0; i<nums.length; i++){
            // 当遇到负数时，最大值和最小值会互换角色
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // 更新以当前元素结尾的最大和最小乘积
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            // 更新全局最大乘积
            max = Math.max(max, imax);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        Solution152 solution152 = new Solution152();
        int maxProduct = solution152.maxProduct(nums);
        System.out.println(maxProduct);
    }
}
