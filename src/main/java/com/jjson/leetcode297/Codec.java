package com.jjson.leetcode297;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jiangjunshen
 * @date 10:28 下午 2020/3/20
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("ni").append(",");
        } else {
            builder.append(root.val).append(",");
            serialize(root.left, builder);
            serialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("ni,".equals(data)) {
            return null;
        }
        String[] strings = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return deserialize(list);
    }
    
    private TreeNode deserialize(LinkedList<String> list) {
        if ("ni".equals(list.getFirst())) {
            list.removeFirst();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.getFirst()));
        list.removeFirst();
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
