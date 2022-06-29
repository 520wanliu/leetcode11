import sun.reflect.generics.tree.Tree;

/**
 * @ClassName day419lowestCommonAncestor
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-19 9:21
 * @Version 1.0
 */

public class day419lowestCommonAncestor {
    public class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val) { this.val = val; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //terminal
        if (root == null || root == p || root == q) return root;

        //drill down
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        //reverse result
        //1、l 和 r 同时为空，即 root 的左右子树都没有 p 和 q ，返回null

        //2、若 l 为空， r 不为空，
        //2.1 p 和 q 都在root的右子树中，最近公共祖先为 r 指向的节点
        //2.2 p 或 q 一个指向root，一个在右子树中，最近公共祖先为 r 指向的节点
        if (l == null) return r;

        //3、若 l 不为空，r 为空，分析同2
        if (r == null) return l;

        //4、l 和 r 同时不为空，则 p 和 q 在root的两侧，公共祖先为root
        return root;
    }
}
