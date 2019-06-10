package com.ling.leetcode.easy;

/**
 * @ClassName HammingDistance_461
 * @Deacription
 * @Author ljxia
 * @Date 2019/06/10 19:44
 * @Version 1.0
 **/
public class HammingDistance_461 {
    public int solution(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        while (temp >0){
            if((temp & 1) == 1){
                //计数
                count ++;
            }
            //右移一位
            temp = temp >> 1;
        }
        return count;
    }
}
