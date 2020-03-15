package com.jjson.leetcode234;

/**
 * @author jiangjunshen
 * @date 7:42 下午 2020/3/15
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode slow = head;
        ListNode quick = head;
        
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode secondHalf = rotate(slow.next);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    
    private ListNode rotate(ListNode head) {
        ListNode previous = null;
        ListNode cur = head;
        while (cur != null) {
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
            next = null;
        }
    }
}
