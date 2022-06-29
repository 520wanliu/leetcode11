package senior_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class generateParenthesis {
    /*public List<String> generateParenthesis(int n){
        List<String> allResult = new ArrayList<>();
        _generateParenthesis(n, 0, 0,"",  allResult);
        return allResult;
    }

    private void _generateParenthesis(int n, int left, int right, String s, List<String> allResult) {
        //terminal
        if (left == n && right == n){
            allResult.add(s);
            return;
        }

        //progress + drill down
        if (left < n){
            _generateParenthesis(n, left + 1, right, s + "(", allResult);
        }
        if (right < left){
            _generateParenthesis(n, left, right + 1, s + ")", allResult);
        }
    }*/

    class TreeNode{
        String val;
        int left,right;

        public TreeNode() { }
        public TreeNode(String val) { this.val = val; }
        public TreeNode(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n){
        List<String> allResult = new ArrayList<>();

        if (n == 0) return allResult;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode("", n, n));

        while (!queue.isEmpty()){
            TreeNode cueNode = queue.poll();
            if (cueNode.left == 0 && cueNode.right == 0){
                allResult.add(cueNode.val);
            }
            if (cueNode.left > 0){
                queue.add(new TreeNode(cueNode.val + "(", cueNode.left - 1, cueNode.right));
            }
            if (cueNode.right > 0 && cueNode.right > cueNode.left){
                queue.add(new TreeNode(cueNode.val + ")", cueNode.left,cueNode.right - 1));
            }
        }
        return allResult;
    }



}













