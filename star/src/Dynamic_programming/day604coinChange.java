package Dynamic_programming;

import java.util.Arrays;

/**
 * @ClassName day604coinChange
 * @Description TODO
 * @Author 橙子
 * @Date 2022-06-04 16:01
 * @Version 1.0
 */

public class day604coinChange {
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
