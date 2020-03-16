package com.jjson.leetcode21;

/**
 * @author jiangjunshen
 * @date 11:08 下午 2020/3/16
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode start = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                start.next = l1;
                l1 = l1.next;
            } else {
                start.next = l2;
                l2 = l2.next;
            }
            start = start.next;
        }
        if (l1 != null) {
            start.next = l1;
        }
        if (l2 != null) {
            start.next = l2;
        }
        return result.next;
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
