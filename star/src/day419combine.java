import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName day419combine
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-19 13:49
 * @Version 1.0
 */

public class day419combine {
    /*public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        //判断每个结果中组合的长度是否在整数区间内
        if (k <= 0 || k > n ) return result;

        //借用中间栈存放来存放从根节点到叶子节点所组成的组合，且该组合满足长度限制
        Deque<Integer> stack = new ArrayDeque<>();
        //由于题目中是从1开始，所以开始遍历的位置为1
        //调用递归函数，以列表形式返回满足约束的组合
        _combine(n, k, 1, stack, result);
        return result;
    }

    private void  _combine(int n, int k, int start, Deque<Integer> stack, List<List<Integer>> result) {
        //terminal：所构成的组合的长度为 k ，将存放当前的从根节点到叶子节点的栈中的遍历路径添加至结果列表result中
        if (stack.size() == k){
            result.add(new ArrayList<>(stack));
            return;
        }
        //process：从1至n遍历可能的树的根节点（路径的起点）
        for (int i = start; i <= n; i++) {
            //将当前节点加入路径中
            stack.addLast(i);

            //drill down
            //从下一个数（即写一个节点）开始搜索，满足组合数中不可出现重复数的限制
            _combine(n, k, i + 1, stack, result);

            //找到从当前节点 i 开始的所有的组合数之后，将栈清空，寻找下一个节点为起点构成的组合
            stack.removeLast();
        }

        //reverse
    }*/

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || k > n){
            return result;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        _combine(n, k, 1, stack, result);
        return result;
    }

    private void _combine(int n, int k, int start, Deque<Integer> stack, List<List<Integer>> result) {
        //terminal
        if (stack.size() == k){
            result.add(new ArrayList<>(stack));
            return;
        }

        //process：缩短遍历范围（一旦满足组合数的长度便停止，避免产生其他结果）
        for (int i = start; i <= n - (k - stack.size()) + 1; i++) {
            stack.addLast(i);
            _combine(n, k, i + 1, stack, result);
            stack.removeLast();
        }
    }
}
