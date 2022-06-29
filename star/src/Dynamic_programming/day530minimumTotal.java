package Dynamic_programming;

import java.util.List;

/**
 * @ClassName day530minimumTotal
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-30 19:46
 * @Version 1.0
 */

public class day530minimumTotal {
/*    public int minimumTotal(List<List<Integer>> triangle) {
        //递归求解
        return _minimunTotal(triangle,0,0);
    }
    private int _minimunTotal(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) return 0;
        return Math.min(_minimunTotal(triangle, row + 1, col), _minimunTotal(triangle, row + 1, col + 1)) + triangle.get(i).get(j);
    }*/

    //动态规划
    public int minimumTotal(List<List<Integer>> triangle){
        //状态转移方程  f[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}










