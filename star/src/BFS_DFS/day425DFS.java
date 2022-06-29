import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName day425DFS
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-25 20:24
 * @Version 1.0
 */

public class day425DFS {

    //深度优先遍历(DFS)代码模板
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

    //深度优先遍历(DFS)代码模板
    public List<List<Integer>> leverOrder(TreeNode root){
        List<List<Integer>> allResult = new ArrayList<>();

        if (root == null) return allResult;

        _DFS(root,0,allResult);
        return allResult;
    }

    private void _DFS(TreeNode root, int level, List<List<Integer>> result) {
        //terminal
        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        //process
        result.get(level).add(root.val);
        //drill down
        if (root.left != null)
            _DFS(root.left, level + 1, result);
        if (root.right != null)
            _DFS(root.right, level + 1, result);
    }
}
