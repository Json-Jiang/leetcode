package com.jjson.leetcode118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangjunshen
 * @date 9:13 下午 2020/3/21
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new LinkedList<>();
        prev.add(1);
        result.add(prev);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                list.add(prev.get(j) + prev.get(j + 1));
            }
            list.add(1);
            result.add(list);
            prev = list;
        }
        return result;
    }
}
