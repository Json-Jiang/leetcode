package com.jjson.leetcode189;

/**
 * @author jiangjunshen
 * @date 8:10 下午 2020/3/14
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
        i = 0;
        j = k - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }

        i = k;
        j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
