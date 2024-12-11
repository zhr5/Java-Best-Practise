package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=(r-l)/2+l;
            if(nums[mid]==target){
                break;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(l>r) return new int []{-1,-1};
        l=mid;
        r=mid;
/*      while(l>0){
            if(nums[l-1]==target) l--;
        }
        while(r<nums.length-1){
            if(nums[r+1]==target) r++;
        }*/
      /*  会进入死循环，因为l=mid时，nums[l-1]!=target，所以l--不动，r=mid时，nums[r+1]!=target，所以r++不动，一直循环下去。*/
        while (l > 0 && nums[l - 1] == target) {
            l--;
        }
        while (r < nums.length - 1 && nums[r + 1] == target) {
            r++;
        }

        return new int []{l,r};
    }
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        Solution34 solution34=new Solution34();
        int[] result=solution34.searchRange(nums,target);
        System.out.println(result[0]+","+result[1]);
    }
}
