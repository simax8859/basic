package com.ling.leetcode.findPairs_532;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FindPairs
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/04 17:57
 * @Version 1.0
 **/
public class FindPairs {
    public int solution(int[] nums, int k){
        int count = 0;
        if (k < 0){
            return 0;
        }
        if (k == 0){
            count = kIsZero(nums);
        }else {
            int length = nums.length;
            HashMap<Integer, Boolean> map = new HashMap<>(length);
            for (int i = 0; i < length; i++) {
                map.put(nums[i],true);
            }
            for (int i = 0; i < length; i++) {
                int value = nums[i];
                int target = value + k;
                if(map.containsKey(target) && map.get(target)){
                    map.put(target,false);
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
            //把索引位置记录下
            map.put(nums[i],i);
        }
        for (int i = 0; i < length; i++) {
            int target = nums[i];
            int targetValue = map.get(target);
            if (map.containsKey(target) && targetValue!=i && targetValue!= -1){
                count++;
                //并且把值置为-1
                map.put(target, -1);
            }
        }
        return count;
    }


}
