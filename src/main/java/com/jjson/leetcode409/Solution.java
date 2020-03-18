package com.jjson.leetcode409;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangjunshen
 * @date 1:07 上午 2020/3/19
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++count);
        }
        int result = 0;
        for (Integer value : map.values()) {
            result += (result | 1) - 1;
        }
        return result + 1;
    }
}
