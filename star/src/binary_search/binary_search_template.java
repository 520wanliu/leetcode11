package binary_search;

/**
 * @ClassName binary_search_template
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-07 10:39
 * @Version 1.0
 */

public class binary_search_template {
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target){
                //找到目标值 : break跳出循环或者返回结果
                break; // or return result
            }else if (arr[mid] > target){
                right = mid - 1;
            }else left = mid + 1;
        }
        return right;
    }
}
