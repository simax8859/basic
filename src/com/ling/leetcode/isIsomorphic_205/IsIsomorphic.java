package com.ling.leetcode.isIsomorphic_205;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IsIsomorphic
 * @Deacription 同构字符串
 * 1.两个字符串变成两个字符串数组，存map,正序反序各执行一遍
 * 2.显然不是最优的办法，但是我TM，发现leetCode更类似于学校考试，多点功利性的思维更容易AC
 * @Author ljxia
 * @Date 2019/5/31 9:06
 * @Version 1.0
 **/
public class IsIsomorphic {

    public boolean solution(String s, String t) {
        boolean judgePositive = judge(s, t);
        boolean judgeReverse = judge(t, s);
        return judgePositive && judgeReverse;
    }

    boolean judge(String s, String t){
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        Map map = new HashMap();
        int length = sBytes.length;
        if (length == 0){
            return true;
        }
        map.put(sBytes[0], tBytes[0]);
        for (int i = 1; i < length; i++) {
            //拿出判断
            Object o = map.get(sBytes[i]);
            if (o == null){
                //没有存过，新存一个
                map.put(sBytes[i], tBytes[i]);
            }else{
                //如果存过，做判断
                if (tBytes[i] != (byte)o){
                    return false;
                }
            }

        }
        return true;
    }
}
