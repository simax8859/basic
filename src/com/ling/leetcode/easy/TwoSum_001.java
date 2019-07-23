package com.ling.leetcode.easy;

import java.util.HashMap;

/**
 * @ClassName TwoSum_001
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/08 15:49
 * @Version 1.0
 **/
public class TwoSum_001 {
    public int[] solution(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(length);
        int[] answer = new int[2];
        for (int i = 0; i < length; i++) {
            //循环，边找边存
            int key = target - nums[i];
            Integer value = map.get(key);
            if (value != null){
                answer[0] = value;
                answer[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}
