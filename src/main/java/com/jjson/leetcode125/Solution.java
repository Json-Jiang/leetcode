package com.jjson.leetcode125;

/**
 * @author jiangjunshen
 * @date 7:28 下午 2020/3/22
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }

        for(int start = 0, end = s.length() - 1; start < end; start++, end--) {
            while (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                if (start >= end) {
                    return true;
                }
            }
            while (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                if (start >= end) {
                    return true;
                }
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("0P"));;
    }
}
