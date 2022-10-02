package Algorithmic_tasks;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // Iterative O(N)
        int maxProfit = 0;
        int minPrice = prices[0];

        for (var price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
