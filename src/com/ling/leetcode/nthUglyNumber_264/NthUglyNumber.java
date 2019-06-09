package com.ling.leetcode.nthUglyNumber_264;

/**
 * @ClassName NthUglyNumber
 * @Deacription
 * @Author ljxia
 * @Date 2019/06/09 19:48
 * @Version 1.0
 **/
public class NthUglyNumber {

    public int solution(int n) {
        //存放前n个丑数
        int[] array =new int[n];
        //动态规划的思想，设定3个变量指定数组脚标位置
        int a = 0;
        int b = 0;
        int c = 0;
        //已知1为首个丑数
        array[0] = 1;
        //遍历寻找n-1次
        for (int i = 1; i < n; i++) {
            //找到最小值，这里直接调用Math.min函数可以到6ms,这种方法12ms。
            int min = min(array[a]*2, array[b]*3, array[c]*5);
            //最小值存入数组
            array[i] = min;
            if (min == array[a]*2){
                a++;
            }
            if (min == array[b]*3){
                b++;
            }
            if (min == array[c]*5){
                c++;
            }
        }
        return array[n-1];
    }

    private int min(int a, int b, int c) {
        int temp = a < b ? a:b;
        temp = temp < c ? temp:c;
        return temp;
    }
}
