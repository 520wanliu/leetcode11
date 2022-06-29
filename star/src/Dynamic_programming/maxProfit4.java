package Dynamic_programming;

import java.util.Arrays;
import java.util.zip.ZipInputStream;

public class maxProfit4 {
    public static int maxProfit4(int k, int[] prices){

//        int n = prices.length;
//        int[][][] dp = new int[n][k][2];
//        for (int i = 0;i <= k; i++){
//            dp[0][k][0] = 0;
//            dp[0][k][1] = -prices[0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = k; j >= 1; j--){
//                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
//                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
//            }
//        }
//        return dp[n - 1][0][0];

        if (prices.length == 0 || k == 0)  return 0;
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, -prices[0]);
        for (int i = 1; i < prices.length; i++){
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++){
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
        }
        return sell[k - 1];
    }


    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int i = maxProfit4(2, prices);
        System.out.println(i);
    }
}
