package com.jjson.leetcode203;

/**
 * @author jiangjunshen
 * @date 5:24 下午 2020/3/15
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        cur.next = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
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
