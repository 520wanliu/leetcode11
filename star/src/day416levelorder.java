import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName day416levelorder
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-16 17:34
 * @Version 1.0
 */

public class day416levelorder {

    public class Node{
        public int val;
        public List<Node> children;
        public Node() { }
        public Node(int val) { this.val = val; }
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        //若根节点为空，N叉树不存在
        if (root == null)
            return new ArrayList<List<Integer>>();

        //定义result列表存放返回的N叉树的层序遍历结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //定义队列作为中间过渡，存放每层节点
        Queue<Node> queue = new ArrayDeque<Node>();
        //层序遍历，先将第一层的根节点存放在队列中
        queue.offer(root);

        while (!queue.isEmpty()){

            //用count统计当前层节点个数，用于对存放当前层节点的队列进行操作
            int count = queue.size();
            //定义lev列表存放每层节点的值
            List<Integer> lev = new ArrayList<Integer>();

            //循环遍历队列中存放的当前层的每个节点
            for (int i = 0; i < count; i++) {
                //将队列中存放的当前层节点依次出队，然后将每个节点的值存放在列表lev中
                Node cur = queue.poll();
                lev.add(cur.val);
                //遍历当前层每个节点的子节点，并将每个节点的子节点存放队列中
                for (Node child : cur.children){
                    queue.offer(child);
                }
            }
            //最后将每层节点的值存放在列表result中，列表result中存放的结果即N叉树的层序遍历结果
            result.add(lev);
        }
        return result;

        /*if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < cnt; ++i) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;*/
    }
}
