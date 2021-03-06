package com.ling.leetcode.middle.maxProfitAssognment_826;

/**
 * @ClassName JustForAcQuestion
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/5/29 16:35
 * @Version 1.0
 **/
public class JustForAcQuestion {
    public int solution(int[] difficulty, int[] profit, int[] worker) {

        int targetLength = difficulty.length;
        //调用快速排序，调整难度顺序，从小到大
        sort(difficulty, profit, 0, targetLength-1);

        //遍历profit数组，从前往后，发现后一个值比前一个小，就将后一个值赋值为前一个较大的
        for (int i = 0; i < targetLength -1; i++) {
            if (profit[i] > profit[i+1]){
                profit[i+1] = profit[i];
            }
        }

        //现在开始计算
        int workerLength = worker.length;
        int sumProfit = 0;
        for (int i = 0; i < workerLength; i++) {
            //现来找一下，这个难度的 是否有
            int workerAbility = worker[i];
            if (workerAbility < difficulty[0]){
                //赚不到钱，不加了继续吧
                continue;
            }else{
                //先从大的找吧
                for (int j = (targetLength - 1); j >= 0; j--) {
                    if (workerAbility >= difficulty[j]){
                        sumProfit = sumProfit + profit[j];
                        //找到了继续下一个
                        break;
                    }
                }
            }
                }
        return sumProfit;
    }

    int partition(int [] difficulty, int [] profit, int lo, int hi){
        //固定的切分方式
        int key = difficulty[lo];
        int keyB = profit[lo];
        while(lo < hi){
            //从后半部分向前扫描
            while(difficulty[hi] >= key&&hi > lo){
                hi--;
            }
            difficulty[lo]=difficulty[hi];
            profit[lo]=profit[hi];
            //从前半部分向后扫描
            while( difficulty[lo] <= key && hi > lo ){
                lo++;
            }
            difficulty[hi]=difficulty[lo];
            profit[hi]=profit[lo];
        }
        difficulty[hi] = key;
        profit[hi] = keyB;
        return hi;
    }

    void sort(int[] difficulty, int [] profit, int lo, int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(difficulty, profit, lo, hi);
        sort(difficulty, profit, lo,index-1);
        sort(difficulty, profit,index+1,hi);
    }
}
