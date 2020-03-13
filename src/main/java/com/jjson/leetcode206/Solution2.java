package com.jjson.leetcode206;

import com.jjson.leetcode206.Solution.ListNode;

/**
 * @author jiangjunshen
 * @date 9:32 下午 2020/3/13
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = recursive(head);
        head.next = null;
        return result;
    }
    
    private ListNode recursive(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode temp = node.next;
        ListNode result = recursive(temp);
        temp.next = node;
        return result;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
