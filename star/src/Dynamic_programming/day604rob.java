package Dynamic_programming;

import javax.print.attribute.standard.NumberUp;

/**
 * @ClassName day604rob
 * @Description TODO
 * @Author 橙子
 * @Date 2022-06-04 16:28
 * @Version 1.0
 */

public class day604rob {
    public int rob(int[] nums){
        /*int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0){
                sum1 += nums[i];
                sum1 = Math.max(sum1, sum2);
            }else{
                sum2 += nums[i];
                sum2 = Math.max(sum1, sum2);
            }
        }
        return Math.max(sum1, sum2);*/

/*
        //用数组a来统计能偷盗的钱的数目，并用第二维数组来标记上一个是否偷盗
        int[][] a = new int[nums.length][2];
        a[0][0] = 0;         //0表示不偷
        a[0][1] = nums[0];   //1表示偷

        for(int i = 1; i < nums.length; i++){   //动态规划方程
            a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
            a[i][1] = a[i - 1][0] + nums[i];
        }
        return Math.max(a[nums.length - 1][0], a[nums.length - 1][1]);*/


        //一维数组实现动态规划
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

        int[] dp = new int[nums.length];
        int res = Math.max(nums[0], nums[1]);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[0];
                continue;
            }
            if (i == 1){
                dp[i] = Math.max(nums[0], nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;


    }
}
