package com.ling.leetcode;

import com.ling.leetcode.easy.HasGroupsSizeX_914;

/**
 * @ClassName Test
 * @Deacription
 * @Author ljxia
 * @Date 2019/06/10 19:48
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
//       String a1 = "aa" + "bb" + "cc";
////       //新的对象，堆中
////       String a = a1 + "dd";
////       String b = "aabbccdd";
////       String c = new String("aabbccdd");
////       String d = new String("aabbccdd").intern();
////       System.out.println("a==b?"+ (a==b));
////       System.out.println("b==c?"+ (b==c));
////       System.out.println("a==c?"+ (a==c));
////       System.out.println("b==d?"+ (b==d));
////       System.out.println("c==d?"+ (c==d));
////       System.out.println("a equals c?"+ (a.equals(c)));

        HasGroupsSizeX_914 hasGroupsSizeX_914 = new HasGroupsSizeX_914();
        int a[] = {1,1,2,2,2,2};
        boolean solution = hasGroupsSizeX_914.solution(a);
        System.out.println(solution);
    }
}
