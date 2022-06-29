import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName day417invertTree
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-17 15:18
 * @Version 1.0
 */

public class day417invertTree {

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

    public TreeNode invertTree(TreeNode root) {
    /*    //递归反转二叉树
        //terminal
        if (root == null) return null;

        //process current logic
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //drill down
        invertTree(root.left);
        invertTree(root.right);

        //reverse states
        return root;*/

        //层序遍历反转二叉树
        if (root == null) return null;

        //1.定义队列将每层节点入队，每次取出对头结点
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        //先将根节点入队
        queue.offer(root);
        //2.获取对头节点，并交换对头节点的左右节点
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode node = cur.left;
            cur.left = cur.right;
            cur.right = node;

            //3.若当前节点的左右节点不为空，将其入队
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return root;
    }
}
