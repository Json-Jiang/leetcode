package com.jjson.leetcode399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 记录上级
        Map<String, String> parent = new HashMap<String, String>();
        // 记录与上级运算的值，value = self / 上级
        Map<String, Double> valueMap = new HashMap<String, Double>();

        int i = 0;
        for (List<String> equation : equations) {
            if (parent.containsKey(equation.get(0))) {
                parent.put(equation.get(1), equation.get(0));
                valueMap.put(equation.get(1), 1.0d / values[i++]);
            } else {
                parent.put(equation.get(0), equation.get(1));
                valueMap.put(equation.get(0), values[i++]);
            }
        }

        for (List<String> equation : equations) {
            find(parent, valueMap, equation.get(0));
            find(parent, valueMap, equation.get(1));
        }

        double[] result = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            List<String> query = queries.get(j);
            String s0 = parent.get(query.get(0));
            String s1 = parent.get(query.get(1));

            if (null == s0 || !s0.equals(s1)) {
                result[j] = -1.0d;
            } else {
                result[j] = valueMap.get(query.get(0)) / valueMap.get(query.get(1));
            }
        }
        return result;
    }
    
    private Tuple<String, Double> find(Map<String, String> parent, Map<String, Double> valueMap, String target) {
        String temp = parent.get(target);
        if (target.equals(temp)) {
            return new Tuple<String, Double>(target, 1.0d);
        }
        if (temp == null) {
            parent.put(target, target);
            valueMap.put(target, 1.0d);
            return new Tuple<String, Double>(target, 1.0d);
        }
        Tuple<String, Double> result = find(parent, valueMap, temp);
        // 路径压缩, 与父节点的值也要重新计算
        double tempValue = result.e * valueMap.get(target);
        valueMap.put(target, tempValue);
        parent.put(target, result.t);
        return new Tuple<String, Double>(result.t, tempValue);
    }
    
    class Tuple<T, E> {
        T t;
        E e;
        
        public Tuple(T t, E e) {
            this.t = t;
            this.e = e;
        }
    }
}
