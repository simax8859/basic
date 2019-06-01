package com.ling.leetcode.search;

/**
 * @ClassName SearchTest
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/01 11:24
 * @Version 1.0
 **/
public class SearchTest {
    public static void main(String[] args) {
        Search_33 search = new Search_33();
        int[] a = {4,5,6,7,0,1,2};
        int solution = search.solution(a, 0);
        System.out.println("测试结果是：" + solution);
    }
}
