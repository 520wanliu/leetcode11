package greedy_algorithm;

import java.util.Arrays;

/**
 * @ClassName day502coinChange
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-02 11:09
 * @Version 1.0
 */

public class day502coinChange {
    /*public int coinChange(int[] coins, int amount){
        int count = 0;
        Arrays.sort(coins);
        if (amount == 0) return 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] >= coins[i]) {
                amount = amount - coins[i];
                count ++;
            }else {
                return -1;
            }
        }
        return amount;
    }*/

    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(memo,amount+1);
        memo[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    // memo[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    memo[i] = Math.min(memo[i],memo[i-coins[j]] + 1);
                }
            }
        }

        return memo[amount] == (amount+1) ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int amount = 0;
        day502coinChange coin = new day502coinChange();
        int i = coin.coinChange(arr, amount);
        System.out.println(i);
    }
}
