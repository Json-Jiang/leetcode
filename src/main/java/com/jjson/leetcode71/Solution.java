package com.jjson.leetcode71;

import java.util.Stack;

/**
 * @author jiangjunshen
 * @date 8:28 下午 2020/3/18
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String s : paths) {
            if (!stack.isEmpty() && "..".equals(s)) {
                stack.pop();
            } else if (!".".equals(s) && !"..".equals(s) && !"".equals(s)) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop()).insert(0, "/");
        }
        return builder.toString();
    }
}
