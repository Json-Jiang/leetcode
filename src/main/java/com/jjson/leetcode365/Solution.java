package com.jjson.leetcode365;

/**
 * @author jiangjunshen
 * @date 6:11 下午 2020/3/21
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) {
            return false;
        }
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        if (z == x || z == y || z == x + y) {
            return true;
        }

        if (min != 0 && max != 0) {
            return z % gcd(max, min) == 0;
        }

        return false;
    }

    private int gcd(int max, int min) {
        int temp = max % min;
        if (temp == 0) {
            return min;
        }
        return gcd(min, temp);
    }
}
