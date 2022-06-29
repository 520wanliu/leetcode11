package Dynamic_programming;

/**
 * @ClassName day530climbStairs
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-30 17:20
 * @Version 1.0
 */

public class day530climbStairs {
    public int climbStairs(int n){
        int f1 = 1, f2 = 2, f3;
        if (n == 1) return n;
        for (int i = 2; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
