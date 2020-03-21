package com.jjson.leetcode200;

import java.util.LinkedList;

/**
 * @author jiangjunshen
 * @date 8:00 下午 2020/3/21
 */
public class Solution1 {
    public int numIslands(char[][] grid) {
        if (null == grid
            || grid.length == 0
            || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i * grid[0].length + j);
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int m = node / grid[0].length;
            int n = node % grid[0].length;
            if (m - 1 >= 0 && grid[m - 1][n] == '1') {
                queue.addLast((m - 1) * grid[0].length + n);
                grid[m - 1][n] = '0';
            }
            if (m + 1 < grid.length && grid[m + 1][n] == '1') {
                queue.addLast((m + 1) * grid[0].length + n);
                grid[m + 1][n] = '0';
            }
            if (n - 1 >= 0 && grid[m][n - 1] == '1') {
                queue.addLast(m * grid[0].length + n - 1);
                grid[m][n - 1] = '0';
            }
            if (n + 1 < grid[0].length && grid[m][n + 1] == '1') {
                queue.addLast(m * grid[0].length + n + 1);
                grid[m][n + 1] = '0';
            }
        }
    }
}
