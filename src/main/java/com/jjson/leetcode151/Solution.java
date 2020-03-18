package com.jjson.leetcode151;

/**
 * @author jiangjunshen
 * @date 8:07 下午 2020/3/18
 */
public class Solution {

    public String reverseWords(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        int p = end + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == ' ') {
                if (i + 1 < p) {
                    builder.append(s, i + 1, p).append(' ');
                }
                p = i;
            }
        }
        builder.append(s, start, p);

        return builder.toString();
    }
}
