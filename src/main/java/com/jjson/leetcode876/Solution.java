package com.jjson.leetcode876;

/**
 * @author jiangjunshen
 * @date 9:56 下午 2020/3/23
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
