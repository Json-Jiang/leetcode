package com.jjson.leetcode116;

/**
 * @author jiangjunshen
 * @date 11:18 下午 2020/3/19
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        link(root.left, root.right, true);
        return root;
    }
    
    public void link(Node left, Node right, boolean flag) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        if (flag) {
            link(left.left, left.right, true);
            link(right.left, right.right, true);
        }
        link(left.right, right.left, false);
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
