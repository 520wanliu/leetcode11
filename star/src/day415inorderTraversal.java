import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName day415inorderTraversal
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-15 9:47
 * @Version 1.0
 */

public class day415inorderTraversal {

    public class TreeNode{
        public int val;
        public TreeNode left,right;
        public TreeNode() { }
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

/*
    //递归方法：二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    public void inorder(TreeNode root,List<Integer> result){
        if (root == null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }*/

    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }*/
}
