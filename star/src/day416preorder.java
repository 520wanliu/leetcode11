import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName day416preorder
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-16 16:57
 * @Version 1.0
 */

public class day416preorder {

    public class Node{
        int val;
        public List<Node> children;
        public Node() { }
        public Node(int val) { this.val = val; }
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

/*    //递归法——N叉树的前序遍历
    public List<Integer> preorder(Node root){
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    public void helper(Node root, List<Integer>result){
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children){
            helper(child,result);
        }
    }*/

    //迭代法——N叉树的前序遍历
    public List<Integer> preorder(Node root){
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;

        Deque<Node> stack = new ArrayDeque<Node>();
        //前序遍历：根左右，先将根节点入栈
        stack.push(root);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            //先将根节点的值保存
            result.add(cur.val);
            //前序遍历：根左右，入栈顺序为从右至左，因此不需要在保证
            for (int i = cur.children.size() - 1; i >= 0 ; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return result;
    }
}


















