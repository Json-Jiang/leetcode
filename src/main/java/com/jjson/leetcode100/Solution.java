package com.jjson.leetcode100;

/**
 * @author jiangjunshen
 * @date 11:44 下午 2020/3/16
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
    
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!dfs(p.left, q.left)) {
            return false;
        }
        return dfs(p.right, q.right);
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
