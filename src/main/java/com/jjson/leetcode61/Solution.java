package com.jjson.leetcode61;

/**
 * 执行很慢，参考官方题解
 * @author jiangjunshen
 * @date 1:17 上午 2020/3/17
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                p2 = head;
            }
            p2 = p2.next;
        }
        if (p2 == null) {
            p2 = head;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = head;
        ListNode result = p1.next;
        p1.next = null;
        return result;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
