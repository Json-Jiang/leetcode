package com.jjson.leetcode204;

/**
 * @author jiangjunshen
 * @date 10:07 下午 2020/3/24
 */
public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] noPrime = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (noPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                noPrime[j] = true;
            }
        }
        int count = 0;
        for (boolean b : noPrime) {
            if (!b) {
                count++;
            }
        }
        return count - 2;
    }

    public static void main(String[] args) {
        boolean[] a = new boolean[1];
        System.out.println(a[0]);
    }
}
