package Dynamic_programming;

/**
 * @ClassName day531maxSubArray
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-31 10:59
 * @Version 1.0
 */

public class day531maxSubArray {
    public int maxSubArray(int[] num){
/*        //动态规划首先对数组进行遍历，当前最大连续子序列和为sum，结果为ans
        //若sum > 0， 则sum对结果有增益效果，则sum保留并加上当前遍历数字
        //若sum < 0， 则sum对结果无增益效果，需要舍弃，则sum直接更新为当前遍历数字
        //每次比较sum和ans的大小，用ans保存最大值，遍历结束后返回结果

        int ans = num[0];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (sum > 0)
                sum += num[i];
            else sum = num[i];
            ans = Math.max(ans, sum);
        }
        return ans;*/

        //将当前指针所指元素进行求和，若和值保存为前一个元素
        // 若前一个元素小于0，舍弃之前队列，若大于0，进行相加
        int maxNum = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] > 0)
                num[i] += num[i - 1];
            maxNum = Math.max(maxNum, num[i]);
        }
        return maxNum;
    }
}
