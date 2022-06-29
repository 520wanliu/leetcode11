package Dynamic_programming;

public class maxProfit2 {
    public int maxProfit2(int[] prices){
        //交易次数无限，在计算时前天没有持有股票当天持有股票时，需要统计当天之前的利润
        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // dp[0][0] = 0;            //第0天不持有股票
        // dp[0][1] = -prices[0];   //第0天持有股票（买入股票），花费prices[0]
        // for (int i = 01; i < n; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // }
        // return dp[n - 1][0];

        //状态压缩
        // int n = prices.length;
        // int[] dp = new int[2];
        // dp[0] = 0;
        // dp[1] = -prices[0];
        // for (int i = 1; i < n; i++){
        //     dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        //     dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        // }
        // return dp[0];

        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for(int i = 1; i < n; i++){
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
