package com.jjson.leetcode169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangjunshen
 * @date 1:26 上午 2020/3/13
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            if (++count > nums.length / 2) {
                return num;
            }
            countMap.put(num, count);
        }
        return 0;
    }
}
