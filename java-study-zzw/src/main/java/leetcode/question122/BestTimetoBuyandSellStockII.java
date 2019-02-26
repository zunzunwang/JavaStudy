package leetcode.question122;

//最佳时间的买入和卖出。 这一次支持多次的买入和卖出。
//18/02/2019
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int current = 0;
        int global = 0;

        for (int i = 1; i < prices.length; i ++){
            current = Math.max(current + prices[i] -prices[i - 1], current);
            global = Math.max(current, global);
        }
        return global;
    }
}
