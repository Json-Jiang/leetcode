package com.jjson.leetcode328;

/**
 * @author jiangjunshen
 * @date 7:22 下午 2020/3/15
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode previous = head;
        ListNode firstEven = head.next;
        int i = 0;
        while (null != cur.next) {
            previous = cur;
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
            i++;
        }
        if ((i & 1) == 0) {
            cur.next = firstEven;
        } else {
            previous.next = firstEven;
        }
        return head;
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
