import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName day412twoSum
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-12 10:11
 * @Version 1.0
 */

public class day412twoSum {

    //利用哈希表，对每个元素x，查询表中是否存在 target - x ，然后将 x 插入哈希表中，避免 x 和自己匹配
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
