package com.ling.leetcode.easy;

/**
 * @ClassName maxProfit_122
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/5/30 11:08
 * @Version 1.0
 **/
public class maxProfit_122 {
    public int solution(int[] prices){
        int sum = 0;
        int length = prices.length;
        if (length < 2){
            return 0;
        }
        for (int i = 1; i < length; i++) {
            int D_value = prices[i] - prices[i - 1];
            if (D_value > 0){
                sum+=D_value;
            }
        }
        return sum;
    }
}
