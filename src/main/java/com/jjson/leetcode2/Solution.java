package com.jjson.leetcode2;

/**
 * 其实可以在短链表高位补0，这样可以省略额外的判断
 * @author jiangjunshen
 * @date 12:57 上午 2020/3/17
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            add(l1, flag);
            cur.next = l1;
        } else if (l2 != null) {
            add(l2, flag);
            cur.next = l2;
        } else if (flag > 0) {
            cur.next = new ListNode(flag);
        }
        return head.next;
    }

    private void add(ListNode node, int flag) {
        if (flag == 0) {
            return;
        }
        ListNode prev = node;
        while (flag > 0 && node != null) {
            int val = node.val + flag;
            node.val = val % 10;
            flag = val / 10;
            prev = node;
            node = node.next;
        }
        if (flag > 0) {
            prev.next = new ListNode(flag);
        }
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
