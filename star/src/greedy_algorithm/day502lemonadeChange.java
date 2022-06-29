package greedy_algorithm;

/**
 * @ClassName day502lemonadeChange
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-02 21:06
 * @Version 1.0
 */

public class day502lemonadeChange {
    //贪心算法
    /*public boolean lemonadeChange(int[] bills){
        int count5 = 0, count10 = 0, count20 = 0;
        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5){
                count5++;
            }
            if (bills[i] == 10){
                if (count5 <= 0) return false;
                count5--;
                count10++;
            }
            if (bills[i] == 20){
                if (count10 > 0 && count5 >0){
                    count10--;
                    count5--;
                    count20++;
                    continue;
                }
                if (count5 >= 3){
                    count5 -= 3;
                    count20++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }*/

    public boolean lemonadeChange(int[] bills){
        int count5 = 0, count10 = 0, count20 = 0;
        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5){
                count5++;
            }else if (bills[i] == 10){
                if (count5 <= 0) return false;
                count5--;
                count10++;
            }else {
                if (count10 > 0 && count5 >0){
                    count10--;
                    count5--;
                    continue;
                }
                if (count5 >= 3){
                    count5 -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
