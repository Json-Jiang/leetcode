package com.jjson.leetcode138;

import java.util.ArrayList;

/**
 * @author jiangjunshen
 * @date 9:49 下午 2020/3/17
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(0);
        Node p1 = head;
        Node p2 = newHead;
        ArrayList<Node> nodes = new ArrayList<>();

        while (p1 != null) {
            p2.next = new Node(p1.val);
            p1 = p1.next;
            p2 = p2.next;
            nodes.add(p2);
        }
        
        int count = 0;
        while (head != null) {
            Node randomNode = head.random;
            head = head.next;
            if (randomNode == null) {
                count++;
                continue;
            }
            int i = 0;
            while (randomNode != null) {
                i++;
                randomNode = randomNode.next;
            }
            nodes.get(count).random = nodes.get(nodes.size() - i);
            count++;
        }
        return newHead.next;
    }

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
