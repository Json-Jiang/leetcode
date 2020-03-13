package com.jjson.leetcode206;

/**
 * @author jiangjunshen
 * @date 8:53 下午 2020/3/13
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head;
        ListNode cur = head.next;
        previous.next = null;
        while (null != cur) {
            ListNode temp = cur.next;
            cur.next = previous;
            previous = cur;
            cur = temp;
        }
        return previous;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
