package com.jjson.leetcode141;

/**
 * @author jiangjunshen
 * @date 8:56 下午 2020/3/14
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;

        while (null != cur1 && cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if (cur1 == cur2) {
                return true;
            }
        }
        return false;
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
