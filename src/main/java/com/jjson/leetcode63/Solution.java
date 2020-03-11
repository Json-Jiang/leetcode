package com.jjson.leetcode63;

/**
 * @author jiangjunshen
 * @date 10:58 下午 2020/3/11
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 特殊输入值处理
        if (null == obstacleGrid || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        // 只有一个元素时处理
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            if (obstacleGrid[0][0] == 1){
                return 0;
            } else {
                return 1;
            }
        }
        // 出发点是障碍物则路径为0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        // 为第一行赋值，只要某个位置为障碍物，则右边的所有方块到达路径为0
        int[] cur = new int[obstacleGrid.length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < obstacleGrid.length; j++) {
                    cur[j] = 0;
                }
                break;
            }
            cur[i] = 1;
        }
        // 记录第一列什么时候有障碍物
        boolean flag = false;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            for (int j = 0; j < obstacleGrid.length; j++) {
                // 有障碍物则当前方块路径为0，同时如果是第一列，更改标志位，代表之后的第一列路径都为0
                if (obstacleGrid[j][i] == 1) {
                    cur[j] = 0;
                    if (j == 0) {
                        flag = true;
                    }
                } else if (j == 0) {
                    // 第一列并且之前第一列出现过障碍物，则路径为0
                    cur[0] = flag ? 0 : 1;
                } else {
                    // 杨辉三角之和
                    cur[j] += cur[j - 1];
                }
            }
        }
        return cur[obstacleGrid.length - 1];
    }
}
