package com.ling.leetcode.easy;

/**
 * @ClassName DeleteNode
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/13 22:11
 * @Version 1.0
 **/
public class IsUgly {
    static int TWO = 2;
    static int THREE = 3;
    static int FIVE = 5;
    public boolean solution(int num) {
        //递归必须设置出口 0：false 1：true
        if (num == 0) {return false;}
        if (num == 1) {return true;}
        //能被2整除的，除2后继续递归
        if (num % TWO == 0) {return solution(num/ TWO);}
        //能被3整除的，除3后继续递归
        if (num % THREE == 0) {return solution(num/ THREE);}
        //能被5整除的，除5后继续递归
        if (num % FIVE == 0) {return solution(num/FIVE);}
        //出口，都不满足返回false
        return false;
    }
}
