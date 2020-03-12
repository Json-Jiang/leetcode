package com.jjson.leetcode226;

/**
 * @author jiangjunshen
 * @date 1:21 上午 2020/3/13
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        flip(root);
        return root;
    }

    private void flip(TreeNode node) {
        if (null != node) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            flip(node.left);
            flip(node.right);
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
