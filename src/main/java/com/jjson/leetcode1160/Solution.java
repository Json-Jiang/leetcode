package com.jjson.leetcode1160;

import java.util.HashMap;
import java.util.Map;

/**
 * 可以用数组代替map
 * @author jiangjunshen
 * @date 1:04 下午 2020/3/17
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            int count = charCount.getOrDefault(chars.charAt(i), 0);
            charCount.put(chars.charAt(i), ++count);
        }

        int result = 0;
        for (String word : words) {
            Map<Character, Integer> temp = new HashMap<>();
            if (word.length() > chars.length()) {
                continue;
            }
            for (int i = 0; i < word.length(); i++) {
                int count = temp.getOrDefault(word.charAt(i), 0);
                if (++count > charCount.getOrDefault(word.charAt(i), 0)) {
                    break;
                }
                if (i == word.length() - 1) {
                    result += word.length();
                    break;
                }
                temp.put(word.charAt(i), count);
            }
        }
        return result;
    }
}
