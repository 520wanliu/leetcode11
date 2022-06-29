import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName day421subsets
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-21 11:17
 * @Version 1.0
 */

public class day421subsets {
    /*
    //分治的思想：依次判断当前数字是否被选择，来组合成新的子集
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (nums == null) return result;
        _subsets(nums,0,res,result);
        return result;
    }

    private void _subsets(int[] nums, int level, List<Integer> res, List<List<Integer>> result) {
        //terminal
        if (level == nums.length){
            result.add(new ArrayList<Integer>(res));
            return;
        }

        //process

        //drill down
        _subsets(nums, level + 1, res, result); //不选当前数字

        res.add(nums[level]); // 选择当前数字，并将其添加至结果列表中
        _subsets(nums, level + 1, res, result);

        //reverse state
        res.remove(res.size() - 1);
    }*/





}

