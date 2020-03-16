package com.jjson.leetcode430;

/**
 * @author jiangjunshen
 * @date 11:16 下午 2020/3/16
 */
public class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        recursive(head);
        return head;
    }
    
    private Node recursive(Node node) {
        if (node.next == null && node.child == null) {
            return node;
        }
        
        if (node.child != null) {
            Node temp = recursive(node.child);
            temp.next = node.next;
            node.next = node.child;
            node.child.prev = node;
            node.child = null;
            if (temp.next != null) {
                temp.next.prev = temp;
                return recursive(temp.next);
            } else {
                return temp;
            }
        } else {
            return recursive(node.next);
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
