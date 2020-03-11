package com.jjson.leetcode62;

import java.util.Arrays;

/**
 * @author jiangjunshen
 * @date 10:34 下午 2020/3/11
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
