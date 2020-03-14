package com.jjson.leetcode707;

/**
 * @author jiangjunshen
 * @date 9:26 下午 2020/3/14
 */
public class MyLinkedList {

    private ListNode head;

    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return - 1;
        }

        ListNode cur = head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (null == head) {
            addAtHead(val);
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            int i = 0;
            ListNode cur = head;
            while (i < index - 1) {
                cur = cur.next;
                i++;
            }
            ListNode insertNode = new ListNode(val);
            insertNode.next = cur.next;
            cur.next = insertNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            int i = 0;
            ListNode cur = head;
            while (i < index - 1) {
                cur = cur.next;
                i++;
            }
            cur.next = cur.next.next;
        }
        size--;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
