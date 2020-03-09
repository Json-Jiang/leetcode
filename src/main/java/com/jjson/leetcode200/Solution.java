package com.jjson.leetcode200;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0
            || i > grid.length - 1
            || j < 0
            || j > grid[0].length - 1
            || grid[i][j] == '2'
            || grid[i][j] == '0') {
            return false;
        }
        grid[i][j] = '2';
        
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        
        return true;
    }
}
