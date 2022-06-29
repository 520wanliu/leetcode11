package Dynamic_programming;

/**
 * @ClassName day531maxProduct
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-31 11:51
 * @Version 1.0
 */

public class day531maxProduct {
    public int maxProduct(int[] nums){
        int maxAns = Integer.MIN_VALUE;

        // 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
        // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。
        // 因此还需要维护当前最小值 imin = min(imin * nums[i], nums[i])
        int imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            //当负数出现时 imax 与 imin 进行交换再进行下一步计算
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            maxAns = Math.max(maxAns, imax);
        }
        return maxAns;
    }
}
