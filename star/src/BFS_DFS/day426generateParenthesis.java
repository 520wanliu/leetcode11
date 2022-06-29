import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName day426generateParenthesis
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-26 10:49
 * @Version 1.0
 */

public class day426generateParenthesis {

/*    public class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode() { }
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //递归
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<String>();
        _generate(0, 0, n, "",result);
        return result;
    }

    private void _generate(int left, int right, int n, String s, List<String> result) {
        //terminal
        if (left == n && right == n){
            result.add(s);
            return;
        }
        //process
        if (left < n){
            _generate(left + 1, right, n, s + "(", result);
        }
        if (right < left){
            _generate(left, right + 1, n, s + ")", result);
        }
    }*/


    //广度优先遍历
    public class TreeNode{
        String val;
        int left,right;
        public TreeNode() { }
        public TreeNode(String val) { this.val = val; }
        public TreeNode(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode("", n, n));

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left == 0 && cur.right == 0)
                result.add(cur.val);

            if (cur.left > 0){
                queue.add(new TreeNode(cur.val + "(", cur.left - 1, cur.right));
            }
            if (cur.right > 0 && cur.right > cur.left){
                queue.add(new TreeNode(cur.val + ")", cur.left, cur.right - 1));
            }
        }
        return result;
    }
}




