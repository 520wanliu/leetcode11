package senior_search;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    class TreeNode{
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

    public List<List<Integer>> leverOrder(TreeNode root){
        List<List<Integer>> allResult = new ArrayList<>();
        if (root == null) {
            return allResult;
        }
        _leverOrder(root,0,allResult);
        return allResult;
    }

    private void _leverOrder(TreeNode root, int level, List<List<Integer>> result) {
        //terminal
        if (result.size() == level)
            result.add(new ArrayList<>());

        //progress
        result.get(level).add(root.val);

        //drill down
        if (root.left != null){
            _leverOrder(root.left, level + 1, result);
        }
        if (root.right != null){
            _leverOrder(root.right, level + 1, result);
        }

        //reverse
    }
}
