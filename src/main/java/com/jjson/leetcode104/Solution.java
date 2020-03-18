package com.jjson.leetcode104;

import com.jjson.leetcode102.Solution.TreeNode;

/**
 * @author jiangjunshen
 * @date 12:55 上午 2020/3/19
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
