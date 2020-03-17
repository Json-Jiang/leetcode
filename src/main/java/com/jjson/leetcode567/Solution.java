package com.jjson.leetcode567;

/**
 * 参考了官方题解
 * @author jiangjunshen
 * @date 11:34 下午 2020/3/17
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }
        
        for (int i = s1.length(); i < s2.length(); i++) {
            if (count == 26) {
                return true;
            }
            
            int rnum = s2.charAt(i) - 'a';
            int r = ++array2[rnum];
            if (r == array1[rnum]) {
                count++;
            } else if (r == array1[rnum] + 1) {
                count--;
            }
            
            int lnum = s2.charAt(i - s1.length()) - 'a';
            int l = --array2[lnum];
            if (l == array1[lnum]) {
                count++;
            } else if (l == array1[lnum] - 1) {
                count--;
            }
        }
        return count == 26;
    }

}
