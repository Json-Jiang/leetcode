package com.jjson.leetcode134;

/**
 * @author jiangjunshen
 * @date 11:28 下午 2020/3/10
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int point = 0;
        int remain = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                remain = 0;
                point = i + 1;
            }
        }
        if (point >= gas.length) {
            return -1;
        }
        for (int i = 0; i < point; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                return -1;
            }
        }
        return point;
    }
}
