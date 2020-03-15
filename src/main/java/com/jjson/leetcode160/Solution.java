package com.jjson.leetcode160;

/**
 * @author jiangjunshen
 * @date 1:39 下午 2020/3/15
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode shorter = headA;
        ListNode longer = headB;
        int difference = Math.abs(lengthB -lengthA);
        if (lengthB < lengthA) {
            shorter = headB;
            longer = headA;
        }
        for (int i = 0; i < difference; i++) {
            longer = longer.next;
        }
        while (shorter != null && longer != null) {
            if (shorter == longer) {
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int i = 0;
        while (null != head) {
            head = head.next;
            i++;
        }
        return i;
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
