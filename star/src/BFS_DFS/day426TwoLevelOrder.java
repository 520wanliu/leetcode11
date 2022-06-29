import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName day426TwoLevelOrder
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-26 10:12
 * @Version 1.0
 */

public class day426TwoLevelOrder {
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

/*    //广度优先遍历
    public List<List<Integer>> twoLevelOrder(TreeNode root){
        List<List<Integer>> allResult = new ArrayList<>();
        if (root == null) return allResult;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> result = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
                result.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            allResult.add(result);
        }
        return allResult;
    }*/

    //深度优先遍历——递归
    public List<List<Integer>> levelOrder(TreeNode root){

        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        _DFS(0,root,result);
        return result;
    }

    private void _DFS(int level, TreeNode root, List<List<Integer>> result) {
        //terminal
        if (level == result.size()){
            result.add(new ArrayList<Integer>());
        }

        //process
        result.get(level).add(root.val);

        //drill down
        if (root.left != null)
            _DFS(level + 1, root.left, result);
        if (root.right != null)
            _DFS(level + 1, root.right, result);
    }


}
