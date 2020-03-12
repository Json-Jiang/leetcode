package com.jjson.leetcode84;

import java.util.Stack;

/**
 * @author jiangjunshen
 * @date 10:24 下午 2020/3/12
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 哨兵
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        int max = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                Integer pop = stack.pop();
                max = Math.max(max, (i - 1 - stack.peek()) * newHeights[pop]);
            }
            stack.push(i);
        }
        return max;
    }
}
