package com.jjson.leetcode105;

/**
 * @author jiangjunshen
 * @date 12:55 上午 2020/3/19
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        }
        TreeNode root = new TreeNode(preorder[start1]);
        int preLeftEnd = 0;
        int inLeftEnd = 0;
        for (int i = start2; i <= end2; i++) {
            if (inorder[i] == root.val) {
                inLeftEnd = i - 1;
                preLeftEnd = start1 + i - start2;
            }
        }
        root.left = build(preorder, start1 + 1, preLeftEnd, inorder, start2, inLeftEnd);
        root.right = build(preorder, preLeftEnd + 1, end1, inorder, inLeftEnd + 2, end2);
        return root;
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
