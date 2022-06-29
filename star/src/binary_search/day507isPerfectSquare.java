package binary_search;

/**
 * @ClassName day507isPerfectSquare
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-07 12:16
 * @Version 1.0
 */

public class day507isPerfectSquare {
    public boolean isPerfectSquare(int num){
        //用内置库函数
        /*double x = Math.sqrt(num);
        return x * x == num;*/

        //二分查找
        /*int left = 0;
        int right = num;
        while (left <= right){
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square < num){
                left = mid + 1;
            }else if (square > num){
                right = mid - 1;
            }else return true;
        }
        return false;*/

        //暴力求解：
        // 如果在遍历过程中出现 x * x > num 的情况，
        // 则更大正整数也不可能满足 x * x == num，
        // 因此只需要判断小于部分的数即可
        long x = 0, square = 1;
        while (square <= num){
            if (square == num){
                return true;
            }
            x++;
            square = x * x;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 4;
        day507isPerfectSquare res = new day507isPerfectSquare();
        boolean b = res.isPerfectSquare(num);
        System.out.println(b);
    }
}
