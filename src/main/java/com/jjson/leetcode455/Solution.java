package com.jjson.leetcode455;

import java.util.Arrays;

/**
 * @author jiangjunshen
 * @date 12:05 上午 2020/3/11
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (null == s || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        // 可以考虑遍历s
        for (int value : g) {
            while (s[j] < value) {
                j++;
                if (j >= s.length) {
                    return count;
                }
            }
            j++;
            count++;
            if (j >= s.length) {
                return count;
            }
        }
        return count;
    }
}

