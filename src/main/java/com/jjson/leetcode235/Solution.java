package com.jjson.leetcode235;

/**
 * @author jiangjunshen
 * @date 7:53 下午 2020/3/12
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min;
        TreeNode max;
        if (p.val < q.val) {
            min = p;
            max = q;
        } else {
            min = q;
            max = p;
        }
        
        TreeNode cur = root;
        while (null != cur) {
            if (cur.val > max.val) {
                cur = cur.left;
            } else if (cur.val < min.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) { val = x; }
    }

}
