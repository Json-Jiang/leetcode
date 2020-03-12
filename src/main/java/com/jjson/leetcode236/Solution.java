package com.jjson.leetcode236;

/**
 * 1. 递归搜索
 * 2. 如果当前节点等于p或者q，那么计数
 * 3. 如果左子树搜到了p或者q，那么计数+1
 * 4. 如果右子树搜到了p或者q，那么计数+1
 * 5. 如果当前计数大于等于2，直接返回当前节点
 * 6. 如果当前节点搜到了p或者q，返回1，否则返回0
 * 
 * @author jiangjunshen
 * @date 8:54 下午 2020/3/12
 */
public class Solution {

    TreeNode node;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return node;
    }

    private int search(TreeNode cur, TreeNode p, TreeNode q) {
        if (null != node) {
            return 0;
        }
        
        if (null != cur) {
            int count = 0;
            if (p == cur || q == cur) {
                count++;
            }
            count += search(cur.left, p, q);
            count += search(cur.right, p, q);
            if (count >= 2) {
                node = cur;
                // 防止多余错误判断
                return 0;
            }
            return count;
        }
        return 0;
    }
    
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
