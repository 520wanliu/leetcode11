package binary_search;

/**
 * @ClassName day508searchRotateSortArray
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-08 10:11
 * @Version 1.0
 */

public class day508searchRotateSortArray {
    public int search(int[] nums, int target){

/*        //二分查找：找到数组中间值，判断前后部分是否为有序数组，对前后部分的有序数组进行二分查找
        if (nums.length == 0 || nums == null){
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                //数组前半部分是有序，判断target是否在前半部分，对其进行二分查找
                if (target >= nums[0] && target < nums[mid]){
                    //此时target在数组的前半部分，右指针指向mid前一个位置
                    right = mid - 1;
                }else {  //target不在数组前半部分
                    left = mid + 1;
                }
            }else {  //数组后半部分有序，判断target是否在后半部分，对其进行二分查找
                if (target >nums[mid] && target <= nums[nums.length - 1]){
                    //此时在数组后半部分对target进行搜素
                    left = mid + 1;
                }else { //target不在数组后半部分
                    right = mid - 1;
                }
            }
        }
        return -1;*/

        //将螺旋数组查找目标转化为有序数组查找目标，
        // 通过对比target与nums[0]的大小和target与mid位置的比较，找出有序数组，
        // 然后调整二分查找的上下界，找出目标值
        int l = 0, r = nums.length - 1;
        while (l <= r){

            //找中间值，若与目标值一致，则找到，返回中间位置
            int mid = l + (r - l) / 2;
            if (target == nums[mid]){
                return mid;
            }

            //对比target与nums[0]大小，判断target在前半部分还是在后半部分，找出有序数组
            if (target >= nums[0]){
                //此时target在前半部分，若mid在后半部分，则将其赋值无穷大覆盖此处的值
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else {
                //此时target在后半部分，若mid前半部分，则将其用无穷小覆盖
                if (nums[mid] >= nums[0]){
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            //对比target值和中间值，对有序数组调整二分查找的上下界
            if (nums[mid] < target){
                l = mid + 1;
            }else r = mid - 1;
        }
        return -1;
    }
}
