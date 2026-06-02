public class leetcode_121 {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }
}
