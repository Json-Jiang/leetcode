package com.jjson.interview40;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiangjunshen
 * @date 1:04 下午 2020/3/20
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.add(arr[i]);
                queue.poll();
            }
        }
        int[] result = new int[k];
        int count = 0;
        for (Integer i : queue) {
            result[count++] = i;
        }
        return result;
    }
}
