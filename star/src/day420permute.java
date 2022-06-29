import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName day420permute
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-20 15:09
 * @Version 1.0
 */

//全排列问题
public class day420permute {
    /*public List<List<Integer>> permute(int[] nums){

        //定义result列表存放最终结果
        List<List<Integer>> result = new ArrayList<>();

        //若数组长度为0，此时数组的全排列结果为空值
        if (nums.length == 0) return result;
//定义中间状态
        //定义route中间栈存放从根节点到叶子节点满足全排列的路径
        Deque<Integer> route = new ArrayDeque<>();
        //定义boolean类型的used数组来判断当前节点是否被访问
        boolean[] used = new boolean[nums.length];

        //函数调用
        dfs_permute(nums,nums.length,0,route,used,result);
        return result;
    }

    private void dfs_permute(int[] nums,  //当前数组
                             int length,  //数组长度
                             int level,   //递归层数，用来作为递归结束条件
                             Deque<Integer> route,  //全排列路径
                             boolean[] used,   //标记当前节点是否已访问
                             List<List<Integer>> result) {

        //terminal：若递归层数与数组长度一致时，递归结束
        if (level == length){
            result.add(new ArrayList<>(route));
            return;
        }

        //process：以数组作为循环条件，依次遍历每个值，构成对应的树，得到对应的全排列结果
        for (int i = 1; i < length; i++) {
            //若当前节点已经在used数组中，说明当前节点已访问
            if (used[i]) continue;

            //若当前节点没有被访问，将其添加至路径中
            route.addLast(nums[i]);
            //标记当前节点已被访问
            used[i] = true;

            //drill down
            dfs_permute(nums,length,level + 1,route,used,result);

            //回溯：回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
            //reverse current state：清空中间数组，并将当前节点清楚标记，递归遍历下一层
            route.removeLast();
            used[i] = false;
        }
    }*/

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> route = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];

        if (nums.length == 0) return result;

        dfs_permute(nums,0,route,used,result);

        return result;
    }

    private void dfs_permute(int[] nums, int level, Deque<Integer> route, boolean[] used, List<List<Integer>> result) {
        //terminal
        if (level == nums.length) {
            result.add(new ArrayList<>(route));
            return;
        }

        //process
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            route.addLast(nums[i]);
            used[i] = true;

            //drill down
            dfs_permute(nums, level + 1, route, used, result);

            //reverse current state
            route.removeLast();
            used[i] = false;
        }
    }


}
