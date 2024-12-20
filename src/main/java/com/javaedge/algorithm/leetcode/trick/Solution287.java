package com.javaedge.algorithm.leetcode.trick;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        //快慢指针
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow!= fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow!= fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public int findDuplicate1(int[] nums) {
       //二分查找
        int l=0,r=nums.length-1;
        int cnt=0;
        int res=-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid) cnt++;
            }
            if(cnt<=mid){
                l=mid+1;
            }else{
                r=mid-1;
                res=mid;
            }
        }
        return res;
    }

}
