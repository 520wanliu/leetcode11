import java.util.*;

/**
 * @ClassName day416postorder
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-16 11:50
 * @Version 1.0
 */

public class day416postorder {
    public class Node{
        int val;
        List<Node> children;
        public Node() { }
        public Node(int val) { this.val = val; }
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
/*    //递归法——N叉树的后序遍历
    public List<Integer> postorder(Node root){
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }
    public void helper(Node root,List<Integer> result){
        if (root == null) return;
        for (Node child : root.children) {
            helper(child,result);
        }
        result.add(root.val);
    }*/

    //迭代法——N叉树的后序遍历
    public List<Integer> postorder(Node root){
        //定义列表存放结果
        List<Integer> result = new ArrayList<Integer>();
        //若当前根节点为空，N叉树不存在，返回当前结果
        if (root == null) return result;

        //定义中间栈，存放从右到左已经遍历的节点
        Deque<Node> stack = new ArrayDeque<Node>();
        //定义一个map集合，用来标识该节点的子节点已经全部入栈
        Set<Node> visited = new HashSet<Node>();
        //后序遍历为：左右根，入栈顺序：根右左，因此先将根节点入栈
        stack.push(root);

        while (!stack.isEmpty()){
            //循环获取栈顶节点，判断当前节点是否为叶子节点或者当前节点的子节点是否已经全部被遍历
            Node cur = stack.peek();
            //若当前节点为叶子节点或者当前节点的子节点全部被遍历，依次出栈，并保存节点的值
            if (cur.children.size() == 0 || visited.contains(cur)){
                stack.pop();
                result.add(cur.val);
                continue;
            }
            //若当前节点的子节点没有被遍历，将其子节点从右至左逆序入栈
            for (int i = cur.children.size() - 1; i >-1 ; i--) {
                stack.push(cur.children.get(i));
            }
            //用map集合visited标识该节点的子节点已经全部入栈
            visited.add(cur);
        }
        return result;
    }
}












