package com.ling.leetcode.easy;

/**
 * @ClassName Search_33
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/01 10:55
 * @Version 1.0
 **/
public class Search_33 {
    /**
     * 整个数组就是一个大有序区间和一个小有序区间的拼凑，照样找，判断二分中位点落在哪，再判target落在哪，就好了
     * @param nums
     * @param target
     * @return
     */
    public int solution(int[] nums, int target) {
        //我来看看长度--\(˙<>˙)/--
        int length = nums.length;
        //我来定义标记--\(˙<>˙)/--
        int start = 0;
        int end = length - 1;
        int index ;
        //来个大循环，遍历遍历遍历！！！
        while (start <= end){
            //用位运算二分，提高效率 ps:但真的会吗，直接除2它也是位运算吧
            index = (start + end) >> 1;
            //提前获取边界值便于后续使用，提高效率
            int index_value = nums[index];
            int start_value = nums[start];
            int end_value = nums[end];
            //判三次，缩小范围，要是都不成功，至少排除了3个，凡事往好的方面想~~~
            if (target == start_value){
                return start;
            }
            if (target == end_value){
                return end;
            }
            if (target == index_value){
                return index;
            }
            //关键时刻，我看看二分中点到底落在哪个区间 o(*￣▽￣*)ブ
            if (start_value < index_value){
                //嘿嘿嘿，落在了大有序区间，正好是个有序区间，那我倒要看看target落在了哪里
                if (target > start_value && target < index_value){
                    //哈哈哈，正好在这个大的有序区间呢，lucky，规律二分，分分分
                    start = start + 1;
                    end = index - 1;
                }else{
                    //啊，落在了外面，继续找找找
                    start = index + 1;
                    end = end -1;
                }
            }else{
                // 咦，落在了小有序区间，看看target落在哪
                if (target > index_value && target < end_value){
                    //lucky，target在小有序区间，二分分分分！！！
                    start = index + 1;
                    end = end -1 ;
                }else{
                    //哈？不在小有序区间里，继续找找找找
                    start = start + 1;
                    end = index - 1;
                }
            }
        }
        //什么都没找到呢，去你MD
        return -1;
    }
}
