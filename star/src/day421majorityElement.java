import java.util.Arrays;

/**
 * @ClassName day421majorityElement
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-21 14:48
 * @Version 1.0
 */

public class day421majorityElement {
    /*
    //排序后返回中间数
    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/

    //摩尔投票法
    public int majorityElement(int[] nums){
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;

        int winner = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == winner) count++;
            else if (count == 0){
                winner = nums[i];
                count++;
            }else count--;
        }
        return winner;
    }

    public static void main(String[] args) {
        day421majorityElement element = new day421majorityElement();
        System.out.println(element.majorityElement(new int[] {2,2,1,1,2,2,2,3}));
    }
}
