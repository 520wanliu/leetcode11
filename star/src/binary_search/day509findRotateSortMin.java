package binary_search;

import java.util.Arrays;

/**
 * @ClassName day509findRotateSortMin
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-09 9:53
 * @Version 1.0
 */

public class day509findRotateSortMin {
    public int findMin(int[] nums){

/*        //排序后第一个数为最小值
        Arrays.sort(nums);
        return nums[0];*/

        //二分查找
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else right = mid;
        }
        return nums[left];

        /*
            疑问：为什么while的条件是low<high,而不是low<=high呢
            解答：low<high，假如最后循环到{*,10,1,*}的这种情况时，nums[low]=10,nums[high]=1,nums[mid]=10,low=mid+1,
                 直接可以跳出循环了,所以low<high,此时low指向的就是最小值的下标;
                 如果low<=high的话，low=high，还会再不必要的循环一次，此时最后一次循环的时候会发生low==high==mid，
                 则nums[mid]==nums[high]，则会走一次else语句，则low=mid+1,此时low指向的是最小值的下一个下标，
                 则需要return[low-1]

        */
    }
}
