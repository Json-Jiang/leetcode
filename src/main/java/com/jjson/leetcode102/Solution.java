package com.jjson.leetcode102;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangjunshen
 * @date 10:14 下午 2020/3/18
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int count1 = 1;
        int count2 = 0;
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            list.add(node.val);
            
            if (node.left != null) {
                queue.addLast(node.left);
                count2++;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                count2++;
            }
            count1--;
            if (count1 == 0) {
                result.add(list);
                list = new LinkedList<>();
                count1 = count2;
                count2 = 0;
            }
        }
        return result;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
