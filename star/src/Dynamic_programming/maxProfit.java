package Dynamic_programming;

public class maxProfit {
    public int maxProfit(int[] prices){
        //动态规划
        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // dp[0][0] = 0;      //第0天不持有股票
        // dp[0][1] = -prices[0];//第0天持有股票
        // for(int i = 1; i < n; i++){
        //     //状态方程
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //     dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        // }
        // return dp[n - 1][0];

        //状态压缩，应为今天 i 只和昨天 i-1 有关，则可用一维表示是否持有股票
        // int n = prices.length;
        // int[] dp = new int[2];
        // dp[0] = 0;
        // dp[1] = -prices[0];
        // for(int i = 1; i < n; i++){
        //      dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        //      dp[1] = Math.max(dp[1], -prices[i]);
        // }
        // return dp[0];

        //语意化
        //用以为表示是否持有股票时，可采用对应的语义单词表示
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for(int i = 1; i < n; i++){
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}
