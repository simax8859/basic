package com.ling.leetcode.maxProfitAssognment_826;

/**
 * @ClassName MaxProfitAssognmentTest
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/05/29 15:09
 * @Version 1.0
 **/
public class MaxProfitAssognmentTest {
    public static void main(String[] args) {
        JustForAcQuestion maxProfitAssignment = new JustForAcQuestion();
        int[] a = {68,35,52,47,86};
        int[] b = {67,17,1,81,3};
        int[] c = {92,10,85,84,82};
        int solution = maxProfitAssignment.solution(a, b, c);
        System.out.println("最大利润是：" + solution);
    }
}
