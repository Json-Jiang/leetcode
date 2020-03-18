package com.jjson.leetcode145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jiangjunshen
 * @date 10:14 下午 2020/3/18
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        stack.push(root);

        // 这种方式遍历经过某个节点会有以下几种情况
        // 1. 第一次经历，左右节点均未经过，如果左右节点均为null，则需要输出，否则按照先左后右的顺序遍历非null节点
        // 2. 第二次经历，从左节点返回，如果右节点为null，则需要输出，否则继续遍历右节点
        // 3. 第三次经历，从右节点返回，需要输出
        while (!stack.isEmpty()) {
            TreeNode n = stack.peek();
            if (n.left != null && n.left != p && n.right != p) {
                stack.push(n.left);
            } else if (n.right != null && n.right != p) {
                stack.push(n.right);
            } else {
                result.add(n.val);
                p = n;
                stack.pop();
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
