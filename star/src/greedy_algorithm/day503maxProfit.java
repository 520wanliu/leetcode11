package greedy_algorithm;

/**
 * @ClassName day503maxProfit
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-03 9:38
 * @Version 1.0
 */

public class day503maxProfit {
    public int maxProfit(int[] price){
        int profit =  0;
//        if (price.length < 2) {
//            return 0;
//        }
        for (int i = 1; i < price.length; i++){
            if (price[i] > price[i - 1]){
                profit += (price[i] - price[i - 1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        day503maxProfit pp = new day503maxProfit();
        int i = pp.maxProfit(price);
        System.out.println(i);
    }
}
