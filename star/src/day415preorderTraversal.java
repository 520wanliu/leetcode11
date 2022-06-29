import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName day415preorderTraversal
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-16 9:17
 * @Version 1.0
 */

public class day415preorderTraversal {
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
    //递归法——前序遍历
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode root,List<Integer> result){
        if (root == null) return;
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }*/

    //迭代法——前序遍历
   /* public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }*/
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}











