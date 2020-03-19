package com.jjson.leetcode106;

/**
 * @author jiangjunshen
 * @date 12:55 上午 2020/3/19
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return build(inorder, 0 , inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        if (start1 == end1) {
            return new TreeNode(inorder[start1]);
        }
        TreeNode root = new TreeNode(postorder[end2]);
        int inLeftEnd = 0;
        int inRightStart = 0;
        int postLeftEnd = 0;
        int postRightStart = 0;
        for (int i = start1; i <= end1; i++) {
            if (inorder[i] == root.val) {
                inLeftEnd = i - 1;
                inRightStart = i + 1;
                postLeftEnd = start2 + i - 1 - start1;
                postRightStart = start2 + i - start1;
                break;
            }
        }
        root.left = build(inorder, start1, inLeftEnd, postorder, start2, postLeftEnd);
        root.right = build(inorder, inRightStart, end1, postorder, postRightStart, end2 - 1);
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
