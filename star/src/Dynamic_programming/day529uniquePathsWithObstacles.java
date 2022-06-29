package Dynamic_programming;

/**
 * @ClassName day529uniquePathsWithObstacles
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-29 19:22
 * @Version 1.0
 */

public class day529uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){

        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        //dp[i][j]表示走到格子(i, j)的方法数
        int[][] dp = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++)  dp[i][0] = 1;
        for(int j = 0; j < n && obstacleGrid[0][j] == 0; j++)  dp[0][j] = 1;
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
