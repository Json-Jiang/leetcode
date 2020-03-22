package com.jjson.leetcode752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 广度优先或者并查集
 * @author jiangjunshen
 * @date 4:56 下午 2020/3/22
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
    }
    
    public int openLock(String[] deadends, String target) {
        Set<Integer> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(Integer.parseInt(deadend));
        }
        return bfs(set, Integer.parseInt(target), 0);
    }
    
    private int bfs(Set<Integer> deadends, int target, int root) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] hasSearch = new int[10000];
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int j = 0; j < levelNum; j++) {
                Integer cur = queue.poll();
                if (cur == target) {
                    return level;
                }
                hasSearch[cur]++;
                int divisor = cur / 10;
                int remainder = cur % 10;
                int i = divisor * 10 + add(remainder);
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }
                i = divisor * 10 + minus(remainder);
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }

                divisor = cur / 100;
                remainder = cur % 100;
                i = divisor * 100 + add(remainder / 10) * 10 + remainder % 10;
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }
                i = divisor * 100 + minus(remainder / 10) * 10 + remainder % 10;
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }

                divisor = cur / 1000;
                remainder = cur % 1000;
                i = divisor * 1000 + add(remainder / 100) * 100 + remainder % 100;
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }
                i = divisor * 1000 + minus(remainder / 100) * 100 + remainder % 100;
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }

                i = add(cur / 1000) * 1000 + cur % 1000;
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }
                i = minus(cur / 1000) * 1000 + cur % 1000;
                if (!deadends.contains(i) && hasSearch[i] == 0) {
                    queue.addLast(i);
                }
            }
            level++;
        }
        return -1;
    }
    
    private int add(int i) {
        if (i == 9) {
            return 0;
        } else {
            return i + 1;
        }
    }
    
    private int minus(int i) {
        if (i == 0) {
            return 9;
        } else {
            return i - 1;
        }
    }
}
