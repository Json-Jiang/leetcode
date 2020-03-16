package com.jjson.interview6;

/**
 * @author jiangjunshen
 * @date 10:31 下午 2020/3/16
 */
public class Solution {
    public String compressString(String S) {
        if (null == S || S.length() <= 1) {
            return S;
        }

        StringBuilder builder = new StringBuilder();
        char cur = S.charAt(0);
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            char now = S.charAt(i);
            if (now == cur) {
                count++;
            } else {
                builder.append(cur).append(count);
                cur = now;
                count = 1;
            }
        }
        builder.append(cur).append(count);
        String newString = builder.toString();
        return newString.length() >= S.length() ? S : newString;
    }
}
