/**
 * @ClassName day417maxDepth
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-17 17:22
 * @Version 1.0
 */

public class day417maxDepth {
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

    public int maxDepth(TreeNode root){
        int count = _maxDepth(root);
        return count;
    }

    private int _maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lcnt = _maxDepth(root.left);
        int rcnt = _maxDepth(root.right);
        return Math.max(lcnt,rcnt) + 1;
    }

}
