package com.jjson.leetcode765;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {

    int count = 0;

    public int minSwapsCouples(int[] row) {
        int[] parent = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i] >> 1;
            parent[row[i]] = row[i];
        }

        for (int i = 0; i < row.length; i += 2) {
            merge(row[i], row[i + 1], parent);
        }
        return count;
    }

    private void merge(int i, int j, int[] parent) {
        int pi = find(i, parent);
        int pj = find(j, parent);
        if (pi == pj) {
            return;
        }
        count++;
        parent[pj] = pi;
    }

    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            return parent[i] = find(parent[i], parent);
        }
        return i;
    }
}

