package Dynamic_programming;

public class maxProfit5 {
    public int maxProfit5(int[] prices){
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        int profit_freeze = 0;
        for (int i = 1; i < n; i++) {
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, profit_freeze - prices[i]);
            profit_freeze = temp;
        }
        return sell;
    }
}
