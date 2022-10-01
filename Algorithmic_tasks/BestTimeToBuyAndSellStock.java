package Algorithmic_tasks;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // Time litim exceeded
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) profit = prices[j] - prices[i];
            }
        }
        if (profit < 0) {
            return 0;
        } else {
            return profit;
        }
    }
}
