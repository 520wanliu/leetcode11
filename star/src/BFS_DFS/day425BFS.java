import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName day425BFS
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-25 20:14
 * @Version 1.0
 */

public class day425BFS {

    //广度优先遍历(BFS)代码模板
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
    //广度优先遍历(BFS)代码模板
    public List<List<Integer>> levelOrder(TreeNode root){
        //存放最终结果
        List<List<Integer>> allResult = new ArrayList<>();
        if (root == null) return allResult;
        //中间队列统计当前层元素
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //存放当前层结果
            List<Integer> result = new ArrayList<>();
            //统计当前层叶子节点个数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                //获取队首元素，并保存元素值，来遍历当前层节点的叶子节点
                TreeNode cur = queue.poll();
                result.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            allResult.add(result);
        }
        return allResult;
    }

    public static void main(String[] args) {
        int i = 5;
        System.out.println(i);
    }
}
