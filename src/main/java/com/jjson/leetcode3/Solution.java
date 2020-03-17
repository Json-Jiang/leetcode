package com.jjson.leetcode3;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 * 每次记录当前字符最近一次出现的位置，头指针如果比该位置靠前，则直接移到该指针之后的位置
 * @author jiangjunshen
 * @date 11:10 下午 2020/3/17
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            length = Math.max(length, j - i + 1);
            map.put(c, j);
        }
        return length;
    }
}
