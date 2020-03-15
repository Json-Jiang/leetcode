package com.jjson.leetcode19;

/**
 * @author jiangjunshen
 * @date 4:58 下午 2020/3/15
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 官方题解， 哑结点的使用
        ListNode p1 = new ListNode(0);
        p1.next = head;
        ListNode temp = p1;
        ListNode p2 = p1;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return temp.next;
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
