package com.ling.leetcode.easy;

/**
 * @ClassName FrequencySort
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/5/27 12:28
 * @Version 1.0
 **/
public class FrequencySort {

    public static void main(String[] args) {
        String test = "lingaaajixiang";

        String solution = solution(test);

        System.out.println("最终排序的结果是：" + solution);
    }

    private static String solution(String test) {

        int[] counts = new int[256];
        int length = test.length();
        //统计每个字符的个数
        for (int i = 0; i < length; i++) {
            counts[test.charAt(i)]++;
        }
        //想法对这个个数进行排序，利用一个对应的char数组，对其进行快速排序，发生交换时，对其做同等操作
        char[] chars = new char[256];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) i;
        }
        sort(counts, chars, 0, 255);
        //现在的chars和counts是对应关系，双重for循环拼接,可以考虑更好方式
        StringBuilder sb = new StringBuilder();
        for (int i = counts.length - 1; i >= 0; i--) {
            char c = chars[i];
            int num = counts[i];
            for (int j = 0; j < num; j++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static int partition(int [] counts, char [] chars, int lo, int hi){
        //固定的切分方式
        int key = counts[lo];
        char keyB = chars[lo];
        while(lo < hi){
            //从后半部分向前扫描
            while(counts[hi] >= key&&hi > lo){
                hi--;
            }
            counts[lo]=counts[hi];
            chars[lo]=chars[hi];
            //从前半部分向后扫描
            while( counts[lo] <= key && hi > lo ){
                lo++;
            }
            counts[hi]=counts[lo];
            chars[hi]=chars[lo];
        }
        counts[hi] = key;
        chars[hi] = keyB;
        return hi;
    }

    public static void sort(int[] array, char [] chars, int lo, int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array, chars, lo, hi);
        sort(array, chars, lo,index-1);
        sort(array, chars,index+1,hi);
    }
}
