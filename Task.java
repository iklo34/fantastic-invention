package com.iyhnica.LESS3;

import java.util.ArrayList;

public class Task {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        ArrayList<Integer> c = new ArrayList<>();
        int a = 0, b = 0;

        while (a < m && b < n) {
            if (nums1[a] < nums2[b]) {
                c.add(nums1[a++]);
            } else {
                c.add(nums2[b++]);
            }
        }
        while (a < m) c.add(nums1[a++]);
        while (b < n) c.add(nums2[b++]);

        int mid = c.size()/2;
        if(c.size() % 2 == 0){
            return (c.get(mid-1) + c.get(mid))/2.0;
        }else{
            return c.get(mid);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] r= new int[2];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i]+nums[j]==target){
                    r=new int[]{i,j};
                }
            }
        }
        return r;
    }
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        boolean b = true;

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                b = true;
            } else {
                b = false;
                break;
            }
        }

        return b;
    }
}


