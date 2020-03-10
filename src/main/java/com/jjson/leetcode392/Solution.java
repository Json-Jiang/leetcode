package com.jjson.leetcode392;

/**
 * @author jiangjunshen
 * @date 10:57 下午 2020/3/10
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (null == s || s.length() == 0) {
            return true;
        }
        int i = 0;

        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) {
                if (++i > s.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
