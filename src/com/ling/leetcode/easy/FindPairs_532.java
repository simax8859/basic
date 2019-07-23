package com.ling.leetcode.easy;

import java.util.HashMap;

/**
 * @ClassName FindPairs_532
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/04 17:57
 * @Version 1.0
 **/
public class FindPairs_532 {
    public int solution(int[] nums, int k){
        //计数，k-diff对
        int count = 0;
        //排除k小于0的情况
        if (k < 0){
            return 0;
        }
        if (k == 0){
            //k为0值时的特殊处理
            count = kIsZero(nums);
        }else {
            //k不为0值的常规处理
            int length = nums.length;
            HashMap<Integer, Boolean> map = new HashMap<>(length);
            //循环存入，k为整数数组中的值（已去重），值为true代表可计数（后续再说）
            for (int i = 0; i < length; i++) {
                map.put(nums[i],true);
            }
            //从整数数组中循环拿数，加上k值去匹配map的k，如果能够匹配到即代表找到一组，将对应的value置false，更为不可计数
            for (int i = 0; i < length; i++) {
                int value = nums[i];
                int target = value + k;
                //匹配到key值，并且显示可计数
                if(map.containsKey(target) && map.get(target)){
                    //value值更新为不可计数
                    map.put(target,false);
                    //计数操作执行，count加1
                    count ++;
                }
            }
        }

        return count;
    }

    private int kIsZero(int[] nums) {
        int length = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            //这里value值记录的为数组脚标
            map.put(nums[i],i);
        }
        //循环判断
        for (int i = 0; i < length; i++) {
            int target = nums[i];
            int targetValue = map.get(target);
            //此处判断条件是：1.匹配到指定的key 2.记录的数组脚标不等于当前脚标（即非同一个数自身）3.值标记不为-1（即可以计数）
            if (map.containsKey(target) && targetValue!=i && targetValue!= -1){
                //执行计数操作
                count++;
                //并且把值标记置为-1，代表不可再计数
                map.put(target, -1);
            }
        }
        return count;
    }
}
