package greedy_algorithm;

/**
 * @ClassName day503jump
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-03 17:59
 * @Version 1.0
 */

public class day503jump {
    public int jump(int[] nums){
        //中间变量，用来存储下一起跳位置
        int temp = 0;
        //用来表示当前位置能条约的最远位置，即边界
        int end = 0;
        //用来统计当前跳跃的步数
        int step = 0;
        //贪心遍历每一个位置元素
        for (int i = 0; i < nums.length - 1; i++) {
            //判断当前位置是否满足下一起跳位置
            temp = Math.max(temp, i + nums[i]);
            //若当前位置已到达可以跳跃的最远位置，标记此处为边界，跳跃成功
            if (i == end){
                end = temp;
                step++;
            }
        }
        return step;
    }
}
