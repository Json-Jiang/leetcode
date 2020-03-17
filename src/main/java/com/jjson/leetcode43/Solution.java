package com.jjson.leetcode43;

/**
 * @author jiangjunshen
 * @date 1:10 上午 2020/3/18
 */
public class Solution {
    public String multiply(String num1, String num2) {
        String value = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                value = add(value, singleMultiply(num1.charAt(i), num2.charAt(j), num1.length() - 1 - i + num2.length() - 1 - j));
            }
        }
        return value;
    }

    private String singleMultiply(char c1, char c2, int zeroNum) {
        int num = (c1 - '0') * (c2 - '0');
        StringBuilder start = new StringBuilder(String.valueOf(num));
        if (num != 0) {
            for (int i = 0; i < zeroNum; i++) {
                start.append('0');
            }
        }
        return start.toString();
    }
    
    private String add(String num1, String num2) {
        int flag = 0;
        StringBuilder result = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int one = i >= 0 ? num1.charAt(i) - '0' : 0;
            int two = j >= 0 ? num2.charAt(j) - '0' : 0;
            result.insert(0, (one + two + flag) % 10);
            flag = (one + two + flag) / 10;
        }
        if (flag > 0) {
            result.insert(0, flag);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        new Solution().multiply("123", "456");
        System.out.println(new Solution().add("2488", "8000"));;
    }
}
