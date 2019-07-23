package com.ling.leetcode.easy;

import java.util.*;

/**
 * @ClassName HasGroupsSizeX_914
 * @Deacription 补14号题目
 * @Author ljxia
 * @Date 2019/06/16 13:25
 * @Version 1.0
 **/
public class HasGroupsSizeX_914 {
    public boolean solution(int[] deck) {
        if (deck == null || deck.length < 2){
            return false;
        }
        int length = deck.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer value ;
        Integer key ;
        //统计所有的数的个数
        for (int i = 0; i < length; i++) {
            key = deck[i];
            value = map.get(key);
            if (value != null){
                //不为null即之前存过值,增加计数
                value++;
                map.put(key,value);
            }else{
                //为null
                map.put(key,1);
            }
        }
        //统计值去重之后，求是否有公约数
        HashSet<Integer> set = new HashSet<>(map.values());
        if (set.size() == 1){
            //去重后只有一个数，这种情况当然可以
            return true;
        }
        //求公约数,这个有点麻烦
        Iterator<Integer> iterator = set.iterator();
        Integer temp = iterator.next();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            //求出temp和next的最大公约数,再用这个最大公约数继续和下一个数求最大公约数
            temp = find(temp, next);
            if (temp == 1){
                //如果最大公约数为1，那就是没有，只能分1组是不行的
                return false;
            }
        }
        return true;
    }

    /**
     * 寻找两数的最大公约数
     * @param a
     * @param b
     * @return
     */
    public Integer find(Integer a, Integer b){
        while(b!=0)
        {
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
