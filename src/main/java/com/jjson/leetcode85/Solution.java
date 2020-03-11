package com.jjson.leetcode85;

import java.util.Arrays;

/**
 * 抄的官方答案
 * @author jiangjunshen
 * @date 11:52 下午 2020/3/11
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];

        Arrays.fill(right, matrix[0].length);
        int area = 0;

        for (char[] chars : matrix) {
            int currentLeft = 0;
            int currentRight = matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == '1') {
                    left[j] = Math.max(left[j], currentLeft);
                } else {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
            }
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (chars[j] == '1') {
                    right[j] = Math.min(right[j], currentRight);
                } else {
                    right[j] = matrix[0].length;
                    currentRight = j;
                }
            }

            for (int j = 0; j < matrix[0].length; j++) {
                int temp = height[j] * (right[j] - left[j]);
                if (temp > area) {
                    area = temp;
                }
            }
        }
        return area;
    }
}
