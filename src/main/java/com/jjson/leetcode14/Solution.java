package com.jjson.leetcode14;

/**
 * @author jiangjunshen
 * @date 11:22 下午 2020/3/17
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String cur = strs[0];

        for (int i = 1; i < strs.length; i++) {
            cur = getPrefix(cur, strs[i]);
        }
        return cur;
    }
    
    private String getPrefix(String s1, String s2) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.length() < s2.length() ? s1 : s2;
    }
    
}
