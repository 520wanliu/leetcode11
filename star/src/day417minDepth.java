/**
 * @ClassName day417maxDepth
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-17 17:22
 * @Version 1.0
 */

public class day417minDepth {

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
/*

    public int minDepth(TreeNode root){
        //1.根节点不存在，空树
        if (root == null) return 0;

        //2.根节点的左右节点均为空
        if (root.left == null && root.right == null)
            return 1;

        //3.当前节点的左右节点有一个为空，则当前树的深度为左子树或右子树的深度+1
        int ldep = minDepth(root.left);
        int rdep = minDepth(root.right);
        if (root.left == null || root.right == null)
            return ldep + rdep + 1;

        //4.当前节点的左右节点均不为空，返回左右子树的最小深度+1
        return Math.min(ldep, rdep) + 1;
    }
*/

    //深度优先搜索——二叉树的最小深度
    public int minDepth(TreeNode root){
        int md = Integer.MAX_VALUE;
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        if (root.right != null)
            md = Math.min(md,minDepth(root.right));
        if (root.left != null)
            md = Math.min(md,minDepth(root.left));
        return md + 1;
    }
}
