package binary_search;

/**
 * @ClassName day507mySqrt
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-07 10:39
 * @Version 1.0
 */

public class day507mySqrt {
    public int mySqrt(int x){

        //该方法没法下取整
        /*if (x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mid * mid > x){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;*/

        /*int left = 0, right = x, result = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return result;*/

        //二分查找
        int left = 0, right = x, result = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            long answer = (long) mid * mid;
            if (answer <= x){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
}
