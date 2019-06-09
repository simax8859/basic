package com.ling.leetcode.countAndSay;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CountAndSay
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/06/08 17:21
 * @Version 1.0
 **/
public class CountAndSay {
    public String solution(int n) {
        //惨了，只能想到一层一层循环，好在最多就30
        //n值为1，直接返回“1”
        if (n == 1){
            return "1";
        }
        //n值不为1，预置一个存有值1的队列
        LinkedList<Integer> temp = new LinkedList<>();
        temp.add(1);
        for (int i = 0; i < n-1; i++) {
            //n-1次 遍历队列中的值 size为当次遍历需要取数的次数
            int size = temp.size();
            //预取出第一个值，是为了方便开始第一次比较
            int num = temp.get(0);
            //计数器
            int count = 0;
            for (int j = 0; j < size; j++) {
                //开始取数，取后即删
                Integer poll = temp.poll();
                if (num == poll){
                    //相同即计数
                    count++;
                }else {
                    //某个数字统计完成，存入队列，顺序：个数，数字
                    temp.add(count);
                    temp.add(num);
                    //开始统计下一个数字
                    num = poll;
                    //因为已经取出一次这个数字，计数为1
                    count = 1;
                }
            }
            //最后一个数字无法进入上面for循环中的else块了，即无法存入队列，这里再处理一下
            temp.add(count);
            temp.add(num);
        }
        //利用StringBuilder，拼接所有字符
        StringBuilder s = new StringBuilder();
        for (int c : temp ){
            s.append(c);
        }
        String string = s.toString();
        //返回字符串
        return string;
    }
}
