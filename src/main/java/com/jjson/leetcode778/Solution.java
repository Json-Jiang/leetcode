package com.jjson.leetcode778;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {
    public int swimInWater(int[][] grid) {
        // 二维转一维经常用到, i = value / N; j = value % N
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            Comparator.comparingInt(t -> grid[t / grid.length][t % grid.length]));
        Set<Integer> seen = new HashSet<>();

        int max = grid[0][0];
        Integer current = 0;

        while (true) {
            int i = current / grid.length;
            int j = current % grid.length;
            if (i >= grid.length - 1 && j >= grid.length - 1) {
                break;
            }

            if (i + 1 < grid.length && !seen.contains(current + grid.length)) {
                queue.add(current + grid.length);
                seen.add(current + grid.length);
            }
            if (i - 1 >= 0 && !seen.contains(current - grid.length)) {
                queue.add(current - grid.length);
                seen.add(current - grid.length);
            }
            if (j + 1 < grid.length && !seen.contains(current + 1)) {
                queue.add(current + 1);
                seen.add(current + 1);
            }
            if (j - 1 >= 0 && !seen.contains(current - 1)) {
                queue.add(current - 1);
                seen.add(current - 1);
            }


            if (queue.size() > 0) {
                current = queue.poll();
            }
            int value = grid[current / grid.length][current % grid.length];
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
