package com.jjson.leetcode695;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangjunshen
 * @date 12:50 下午 2020/3/15
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int[] parent = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = i * grid[0].length + j;
                parent[val] = val;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int val = i * grid[0].length + j;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    merge(parent, val, val - grid[0].length);
                }
                if (i + 1 < grid.length  && grid[i + 1][j] == 1) {
                    merge(parent, val, val + grid[0].length);
                }
                if (j - 1 >= 0  && grid[i][j - 1] == 1) {
                    merge(parent, val, val - 1);
                }
                if (j + 1 < grid[0].length   && grid[i][j + 1] == 1) {
                    merge(parent, val, val + 1);
                }
            }
        }

        Map<Integer, Integer> area = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int val = i * grid[0].length + j;
                int par = find(parent, val);
                Integer pArea = area.getOrDefault(par, 0);
                area.put(par, pArea + 1);
            }
        }

        int max = 0;
        for (Integer value : area.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
    
    private void merge(int[] parent, int i, int j) {
        int ip = find(parent, i);
        int jp = find(parent, j);

        if (ip != jp) {
            parent[jp] = ip;
        }
    }
}
