package com.ling.leetCode.maxProfitAssognment_826;

import java.util.HashMap;

/**
 * @ClassName Ex
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/05/29 14:23
 * @Version 1.0 错误理由，需要考虑到从事难度更低的工作反而收益更高，安排表那块儿更改
 **/
public class MaxProfitAssignment {
    public int solution(int[] difficulty, int[] profit, int[] worker) {
        //定义一个hashmap
        HashMap<Integer, Integer> chooses = new HashMap<>();
        //节约时间，先算各个长度
        int taskLength = difficulty.length;
        int workerSum = worker.length;
        for (int i = 0; i < taskLength; i++) {
            //遍历来安排一个选择表
            int diff = difficulty[i];
            int prof = profit[i];
            //有没有同难度的呀，找不到会返回null
            Integer e = chooses.get(diff);
            int value = (e == null ? 0 : e);
            if (prof > value) {
                chooses.put(diff, prof);
            }
        }
        //好的，全部安排上了，开始计算效益,加加加
        int sumProfit = 0;
        for (int i = 0; i < workerSum; i++) {
            //看看有没有对应的收益啊
            Integer singleProfit = 0;
            Integer workerAbility = worker[i];
            while ((singleProfit = chooses.get(workerAbility)) == null){
                //降低期望
                workerAbility--;
                if(workerAbility == 0){
                    singleProfit = 0;
                    break;
                }
            }
            sumProfit = sumProfit + singleProfit;
        }
        return sumProfit;
    }
}
