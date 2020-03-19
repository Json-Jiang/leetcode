package com.jjson.leetcode117;

/**
 * @author jiangjunshen
 * @date 11:18 下午 2020/3/19
 */
public class Solution {

    /**
     * 同一层的上一个节点
     */
    Node prev;
    
    /**
     * 同一层最左边的节点
     */
    Node leftMost;
    
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        this.leftMost = root;
        this.prev = root;
        
        while (this.leftMost != null) {
            Node cur = this.leftMost;
            // 每次开始重置下一层的最左边节点以及这一层的上一个节点
            prev = null;
            this.leftMost = null;
            while (cur != null) {
                processChild(cur.left);
                processChild(cur.right);
                cur = cur.next;
            }
        }
        return root;
    }
    
    private void processChild(Node node) {
        if (node != null) {
            if (this.prev == null) {
                this.leftMost = node;
            } else {
                this.prev.next = node;
            }
            this.prev = node;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
