package com.jjson.leetcode684;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int pi = find(edge[0] - 1, parent);
            int pj = find(edge[1] - 1, parent);
            if (pi == pj) {
                return edge;
            }
            parent[pj] = pi;
        }
        return new int[]{0, 0};
    }
    
    private int find(int i, int[] parent) {
        if (i != parent[i]) {
            return parent[i] = find(parent[i], parent);
        }
        return i;
    }
}
