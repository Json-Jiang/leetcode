package com.jjson.leetcode142;

/**
 * @author jiangjunshen
 * @date 12:46 下午 2020/3/15
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 表头为null或者只有一个节点证明无环
        if (null == head || null == head.next) {
            return null;
        }

        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = meetNode;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private ListNode getMeetNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (slow.next != null && quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return slow;
            }
        }
        return null;
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
