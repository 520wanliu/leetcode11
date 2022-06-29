package Dynamic_programming;

/**
 * @ClassName day530longestCommonSubsequence
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-30 9:34
 * @Version 1.0
 */

public class day530longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
    /*    //将两个字符串存入二维数组中
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();

        //利用二维数组判断text1[i - 1][j] 和 text2[i][j - 1] 的位置对应的字符是否一致
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        //若一致，则dp[i][j]位置的数字（即公共子长度值）为 dp[i - 1][j - 1] + 1
        //若不一致，则dp[i][j]位置的数字（即公共子长度值）为其最大值: Math.max(dp[i - 1][j], dp[i][j - 1])
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (array1[i - 1] == array2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];*/

        int m = text1.length();
        int n = text2.length();

        text1 = " " + text1;
        text2 = " " + text2;

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        // 因为有了追加的空格,开始初始化值
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int j = 0; j <= n; j++) dp[0][j] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i -1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //减去开始追加的空格
        return dp[m][n] - 1;
    }
}
