package Dynamic_programming;

import sun.management.jdp.JdpGenericPacket;

import java.util.Arrays;

public class rob2 {
    public int rob(int[] nums){
        /*
            情况分类：
                1、不抢头，不抢尾
                2、抢头，不抢尾
                3、不抢头，抢尾
        */
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums3 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(myRob(nums1), Math.max(myRob(nums2), myRob(nums3)));
    }

    private int myRob(int[] nums) {

        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

        int[] dp = new int[nums.length];
        int res = Math.max(nums[0], nums[1]);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[0];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[0],nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
