package com.jjson.leetcode94;

import com.jjson.leetcode144.Solution.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jiangjunshen
 * @date 10:51 下午 2020/3/18
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
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
