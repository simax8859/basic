package com.ling.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateParenthesis_22
 * @Deacription
 * @Author ljxia
 * @Date 2019/06/12 18:51
 * @Version 1.0
 **/
public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        //两个停止判断条件 1.当左括号的个数等于n，补齐右括号可以停了   2.当右括号的个数大于左括号，直接放弃退出
        ArrayList<String> list = new ArrayList<>();
        generate(list,n,0,0,"",true);
        return list;
    }

    /**
     * @param list 供存入最后结果
     * @param n 括号对数
     * @param left 左括号个数
     * @param right 右括号个数
     * @param str 传入的已有字符串，供下一步拼接
     * @param flag 如果为true 拼接左括号
     */
    public void generate(ArrayList<String> list, int n, int left, int right, String str, boolean flag){
        if (left == n){
            //补齐右括号存好退出
            int num = n - right;
            while (num > 0 ){
                str = str + ")";
                num--;
            }
            //保存当前的这个结果，结束
            list.add(str);
            return;
        }
        //如果右括号大于了左括号，没法形成一对了，结束
        if (right > left){
            return;
        }
        //根据标志来添加左右括号
        if (flag){
            str = str + "(";
            left++;
        }else {
            str = str + ")";
            right++;
        }
        //这里需要考虑一点，要是第一个方法已经存了str，那么后面那个千万不要进去了，不然又要存一次
        generate(list, n , left, right, str, true);
        //只允许执行一次
        if (left == n && right > left){
            return;
        }
        generate(list, n , left, right, str, false);
    }
}
