import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName day419buildTree
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-19 10:33
 * @Version 1.0
 */

public class day419buildTree {
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


    private TreeNode buildTree(int[] preorder, int[] inorder) {
/*      //递归思想
        //terminal
        if (preorder.length == 0 || inorder.length == 0) return null;

        //process
        //前序遍历：根-左-右，因此前序遍历第一个节点为根节点，保存当前节点
        TreeNode root = new TreeNode(preorder[0]);
        //以前序遍历结果作为参考
        for (int i = 0; i < preorder.length; i++) {
            //寻找中序遍历中与前序遍历的第一个节点相等的节点，作为中序遍历的中间节点来判断左右子树
            if (preorder[0] == inorder[i]){
                //根据找到的中序遍历中的根节点，并确定根节点的左右子树
                int[] l_inorder = Arrays.copyOfRange(inorder,0, i);
                int[] r_inorder = Arrays.copyOfRange(inorder,i + 1, inorder.length);
                //根据中序遍历中的左右子树来对前序遍历进行左右子树的划分，并确定左右子树的根节点
                int[] l_preorder = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] r_preorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);

        //drill down
                //以此递归，构造二叉树
                root.left = buildTree(l_preorder,l_inorder);
                root.right = buildTree(r_preorder,r_inorder);
                break;
            }
        }

        return root;*/

        //调用栈的迭代
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> roots = new Stack<TreeNode>();
        int pre = 0;
        int in = 0;
        //先序遍历第一个值作为根节点
        TreeNode curRoot = new TreeNode(preorder[pre]);
        TreeNode root = curRoot;
        roots.push(curRoot);
        pre++;
        //遍历前序遍历的数组
        while (pre < preorder.length) {
            //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
            if (curRoot.val == inorder[in]) {
                //每次进行出栈，实现倒着遍历
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in++;
                }
                //设为当前的右孩子
                curRoot.right = new TreeNode(preorder[pre]);
                //更新 curRoot
                curRoot = curRoot.right;
                roots.push(curRoot);
                pre++;
            } else {
                //否则的话就一直作为左子树
                curRoot.left = new TreeNode(preorder[pre]);
                curRoot = curRoot.left;
                roots.push(curRoot);
                pre++;
            }
        }
        return root;
    }
}
