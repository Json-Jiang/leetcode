package com.jjson.leetcode547;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {

    int count = 0;

    public int findCircleNum(int[][] M) {
        if (null == M || M.length == 0) {
            return 0;
        }
        // 初始化朋友圈数量 & parent数组
        count = M.length;
        int[] parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    merge(i, j, parent);
                }
            }
        }
        return count;
    }

    private void merge(int i, int j, int[] parent) {
        int parenti = find(i, parent);
        int parentj = find(j, parent);
        if (parenti == parentj) {
            return;
        }
        count--;
        parent[parentj] = parenti;
    }

    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            return parent[i] = find(parent[i], parent);
        }
        return i;
    }
}
