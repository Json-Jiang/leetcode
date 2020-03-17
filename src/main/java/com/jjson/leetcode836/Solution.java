package com.jjson.leetcode836;

/**
 * @author jiangjunshen
 * @date 1:06 上午 2020/3/18
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2]
            || rec1[2] <= rec2[0]
            || rec1[1] >= rec2[3]
            || rec1[3] <= rec2[1]);
    }
}
