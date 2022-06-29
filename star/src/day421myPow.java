/**
 * @ClassName day421myPow
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-21 9:39
 * @Version 1.0
 */

public class day421myPow {
    public double myPow(double x, int n) {
        double result = 1.0;

//        if(n < 0) {
//            x = 1 / x;
//            n = -n;
//        }
        if (n < 0){
            result = 1.0 / myPow(x,-n);
            return result;
        }

        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0){
                result = result * x;
            }
            x = x * x;
        }
        return result;
    }
    /*public double myPow(double x, int n){
        double result = 1.0;
        if (n == 0)
            return 1.0;
        if(n < 0){
            x = 1 / x;
            n = -n;
        }

        result = myPow(x, n / 2);

        if (n % 2 == 0){
            result = result * result;
        }else{
            result = result * result * x;
        }
        //此时要注意除数为0的情况
        //报类型错误：NumberFormatException:infinite or NAN
        if(result == 0) return 0;

        return n < 0 ? 1 / result : result;
    }
    }*/

    public static void main(String[] args) {
        day421myPow sou = new day421myPow();
        double result = sou.myPow(2,5);
        System.out.println(result);

    }
}
