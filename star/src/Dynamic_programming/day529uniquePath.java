package Dynamic_programming;

/**
 * @ClassName day529uniquePath
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-29 19:04
 * @Version 1.0
 */

/*
    动态方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    对于第一行dp[0][i],第一列dp[i][0]都是在左边界，值为1
    每次只需要探索右边和下边两个位置的空格（即动态规划两个方向），
    因此每次只需要对dp[i - 1][j] 和 dp[i][j - 1]求和所得
*/

public class day529uniquePath {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)  dp[i][0] = 1;
        for (int i = 0; i < n; i++)  dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
