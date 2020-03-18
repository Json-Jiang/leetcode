package com.jjson.leetcode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jiangjunshen
 * @date 10:14 下午 2020/3/18
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                cur = stack.pop().right;
            } else {
                break;
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
