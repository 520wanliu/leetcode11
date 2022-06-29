import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName day426largestValues
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-26 11:02
 * @Version 1.0
 */

public class day426largestValues {
    public class TreeNode{
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int cnt = queue.size();
            int maxnum = Integer.MIN_VALUE;
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
//                if (cur.val > maxnum)
//                    maxnum = cur.val;
                //maxnum = Math.max(maxnum, cur.val);
                maxnum = cur.val > maxnum ? cur.val : maxnum;

                if (cur.left != null)  queue.add(cur.left);
                if (cur.right != null)  queue.add(cur.right);
            }
            result.add(maxnum);
        }
        return result;
    }
}
