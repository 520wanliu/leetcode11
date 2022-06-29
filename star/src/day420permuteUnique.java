import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName day420permuteUnique
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-20 19:57
 * @Version 1.0
 */

public class day420permuteUnique {
    /*public List<List<Integer>> permuteUnique(int[] nums){
        //result列表存放结果
        List<List<Integer>> result = new ArrayList<>();
        //定义per列表存放当前排列结果，以此判断当前排列结果是否满足条件
        List<Integer> route = new ArrayList<>();

        //定义boolean类型used数组来标识当前数字是否重复
        boolean[] used = new boolean[nums.length];

        //对数组进行排序
        Arrays.sort(nums);
        dfs_permuteUnique(nums,0,result,route,used);
        return result;
    }

    private void dfs_permuteUnique(int[] nums, int level, List<List<Integer>> result, List<Integer> route, boolean[] used) {
        //terminal：递归层数与数组长度一致时，递归结束，将当前排列结果存入最终结果
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(route));
            return;
        }

        //process：循环遍历数组长度
        for (int i = 0; i < nums.length; i++){
            //如果当前数字被标记或当前数字与前一个数字重复时，跳过该排列结果
            if (used[i] ||(i > 0 && !used[i - 1] && nums[i] == nums[i - 1])){
                continue;
            }
            //当前数字没有被标记且与之前数字不重复时，有效，将其添加至当前排列结果中，并对其标记
            route.add(nums[i]);
            used[i] = true;

            //drill down：递归遍历下一层
            dfs_permuteUnique(nums, level + 1, result, route, used);

            //reverse current state：回溯从 深层结点 回到 浅层结点 的过程，并对当前数字撤销标识
            route.remove(level);
            used[i] = false;
        }
    }*/

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        _permuteUnique(nums,0,used,route,result);
        return result;
    }

    private void _permuteUnique(int[] nums, int level, boolean[] used, List<Integer> route, List<List<Integer>> result) {
        //terminal
        if (level == nums.length){
            result.add(new ArrayList<>(route));
            return;
        }
        //process
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && !used[i-1] && nums[i] == nums[i - 1])) continue;
            route.add(nums[i]);
            used[i] = true;

            //drill down
            _permuteUnique(nums, level + 1, used, route, result);

            //reverse current state
            route.remove(level);
            used[i] = false;
        }
    }
}
