package com.jjson.leetcode945;

/**
 * 参考题解，计数排序或者线性探测
 * @author jiangjunshen
 * @date 4:02 下午 2020/3/22
 */
public class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        
        int[] count = new int[max - min + 2];
        for (int i : A) {
            count[i - min]++;
        }
        int ans = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] > 1) {
                // 先把count[i] - 1个i移动到count[i+1]，一共move了count[i] - 1次
                ans += count[i] - 1;
                count[i + 1] += count[i] - 1;
            }
        }
        // 最后一个数字处理
        if (count[count.length - 1] >= 2) {
            ans += count[count.length - 1] * (count[count.length - 1] - 1) / 2;
        }
        return ans;
    }
}
