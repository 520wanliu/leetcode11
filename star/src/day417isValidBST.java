import java.util.Stack;

/**
 * @ClassName day417isValidBST
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-17 16:07
 * @Version 1.0
 */

public class day417isValidBST {

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

    //递归遍历——验证二叉搜索树
    public boolean isValidBST(TreeNode root){
        return BST(root,null,null);
    }

    private boolean BST(TreeNode root, Integer lower, Integer higher) {
        if (root == null) return true;

        //若当前节点不为空，判断当前节点的值是否满足上下界要求
        int value = root.val;
        if (lower != null && value <= lower) return false;
        if (higher != null && value >= higher) return false;

        //当前节点满足上下界要求，则递归遍历判断其左右节点是否满足二叉搜索树
        if (!BST(root.right, value, higher)) return false;
        if (!BST(root.left, value, lower)) return false;
        return true;
    }

    //中序遍历——验证二叉搜索树
    //利用中序遍历得到的二叉搜索树是升序的特性
     /*public boolean isValidBST(TreeNode root){
       //定义中间栈存储为访问的节点
        Stack<TreeNode> stack = new Stack();
        //定义整数Integer来存储遍历的上一个节点
        Integer pre = null;

        while (!stack.isEmpty() || root != null){
            //循环遍历将左节点入栈
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //从栈中取出最左边的节点，判断当前值与上一个节点值大小
            if (root.val <= pre && pre != null)
                return false;
            //将当前节点的值保存在pre中，判断其右节点
            pre = root.val;
            root = root.right;
        }
        return true;
    }*/
}
