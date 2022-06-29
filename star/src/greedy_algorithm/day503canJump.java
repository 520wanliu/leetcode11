package greedy_algorithm;

/**
 * @ClassName day503canJump
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-03 11:29
 * @Version 1.0
 */

public class day503canJump {
    //错的
    /*public boolean canJump(int[] nums){
        int temp = 0;
        if (nums.length == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = temp; j < nums.length; j++) {
                if (i + nums[i] < nums.length){
                    temp = i + nums[i];
                }
            }
        }
        return true;
    }*/

    //正确
    /*public boolean canJump(int[] nums){
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= temp){
                temp = Math.max(temp, i + nums[i]);
                if (temp >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }*/

    public boolean canJump(int[] nums){
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > temp) return false;
            temp = Math.max(temp, i + nums[i]);
        }
        return true;
    }
}
