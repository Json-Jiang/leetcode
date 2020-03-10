package com.jjson.leetcode122;

/**
 * @author jiangjunshen
 * @date 10:40 下午 2020/3/10
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 1) {
            return 0;
        }
        int result = 0;
        int start = 0;
        int end = 1;

        while (end < prices.length) {
            if (prices[end] >= prices[end - 1]) {
                end++;
                continue;
            }
            result += prices[end - 1] - prices[start];
            start = end++;
        }
        if (start != end - 1) {
            result += prices[end - 1] - prices[start];
        }
        return result;
    }
}
