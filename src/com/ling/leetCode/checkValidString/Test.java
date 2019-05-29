package com.ling.leetCode.checkValidString;

/**
 * @ClassName Test
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/05/29 10:19
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        Boolean solution = checkValidString.solution(")()(***)()()***)(");
        System.out.println(solution);
    }
}
