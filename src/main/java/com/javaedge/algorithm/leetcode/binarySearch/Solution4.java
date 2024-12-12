package com.javaedge.algorithm.leetcode.binarySearch;

public class Solution4 {
    //寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        int aStart=0,bStart=0;
        int left=-1,right=-1;
        for(int i=0;i<=(len1+len2)/2;i++){
            left=right;
            if(aStart<len1&&(bStart>=len2||nums1[aStart]<=nums2[bStart])){
                right=nums1[aStart++];
            }else{
                right=nums2[bStart++];
            }

        }
        if((len1+len2)%2==1) return right;
        return (left+right)/2.0;
    }
}
