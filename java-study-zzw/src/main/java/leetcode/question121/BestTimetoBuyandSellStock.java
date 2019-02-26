package leetcode.question121;

//18/02/2019
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int currentMax = 0;
        //最差则始终不买不卖。 则可以保持值为0。
        int globalMax = 0;

        for (int i = 1; i < prices.length; i ++){
            /**
             * 这里一定要注意是current 和 current + value进行最大值的比较。
             */
            currentMax = Math.max(prices[i] - prices[i-1], prices[i] - prices[i-1] + currentMax);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
