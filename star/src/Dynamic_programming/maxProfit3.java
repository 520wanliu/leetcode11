package Dynamic_programming;

public class maxProfit3 {
    public int maxProfit3(int[] prices){
        //状态转移方程   k值对结果有影响时
//        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices);
//        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices);

       /* int n = prices.length;
        int[][][] dp = new int[n][2][2];

        dp[0][1][0] = 0;
        dp[0][2][0] = 0;

        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);

            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
        }
        return dp[n - 1][0][0];*/

        int n = prices.length;
        int sell2 = 0 ,  sell1 = 0;
        int buy2 = -prices[0], buy1 = -prices[0];
        for (int i = 1; i < n; i++) {
            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);

            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
    }
}
