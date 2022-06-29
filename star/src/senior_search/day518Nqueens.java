package senior_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName day518Nqueens
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-18 9:41
 * @Version 1.0
 */

class day518Nqueens {
    /*List<List<String>> res = new ArrayList<>();

    *//* 输入棋盘的边长n，返回所有合法的放置 *//*
    public List<List<String>> solveNQueens(int n) {
        // "." 表示空，"Q"表示皇后，初始化棋盘
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        // 每一行都成功放置了皇后，记录结果
        if (row == board.length) {
            res.add(charToList(board));
            return;
        }

        int n = board[row].length;
        // 在当前行的每一列都可能放置皇后
        for (int col = 0; col < n; col++) {
            // 排除可以相互攻击的格子
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行放皇后
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    *//* 判断是否可以在 board[row][col] 放置皇后 *//*
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }*/
    /*
        本题也是回溯算法的经典题目。N 皇后问题也是一个暴力穷举的问题。
        1、其实题目可以改成，在每一行放置一个皇后，让这些皇后不能相互攻击。（因为每一行最多只有一个皇后）
            1.1 我们可以先不考虑每一个皇后之间不能相互攻击的条件，如果要求每行只能放一个皇后，我们能否穷举出所有的放置方法？
        2、考虑皇后之间相互攻击的问题
            2.1 对于每一个格子进行计算分析能不能放置皇后，最后的代码实现会跳过这些格子，把皇后放在合法的位置上。
            2.2 具体的，在每一个位置放置皇后，然后调用 backtrack 函数，进入下一行进行穷举进行判断
        3、isValid 函数的逻辑
           按照题意我们需要检查八个方向是否有其他方向，但实际上我们只需要检查三个方向即可。
              ① 因为我们的逻辑是每一行只放一个皇后，所以这个皇后的左边和右边不需要进行检查了。
              ② 因为我们是一行一行从上向下放置皇后，所以下方，左下方和右下方不会有皇后（还没放皇后）。
              ③ 最后我们需要检查的只有上方、左上和右上三个方向。
        4、函数 backtrack 依然像个在决策树上游走的指针，每个节点就表示在 board[row][col] 上放置皇后，
           通过 isValid 函数可以将不符合条件的情况剪枝。
    */

    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n){
        //初始化棋盘，将每个位置都赋值"."
        char board[][] = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c,'.');
        }
        backTracking(n,board,0);
        return answer;
    }

    private void backTracking(int n, char[][] board, int row) {
        //terminal
        //此时每一行都放置了Q，保存结果
        if (row == n){
            answer.add(ListBoard(board));
            return;
        }

        //drill down
        //当前行的每一列都可能被放置Q
        for (int col = 0; col < n; col++){

            //节点处理——此处判断当前放置Q的位置是否有效
            //不是有效位置，跳过当前位置
            if (!isValid(board,row,col,n)){
                continue;
            }
            //是有效位置，存放Q
            board[row][col] = 'Q';

            //递归判断下一行，放置Q
            backTracking(n, board, row + 1);

            //回溯，撤销处理节点操作
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        //处理列方向Q的冲突问题
        for (int i = 0; i < n; i++) { //剪枝操作
            if (board[i][col] == 'Q')
                return false;
        }

        //处理45度角方向Q的冲突问题
        for (int i = row - 1, j = col + 1; i >=0 && j <n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        //处理135度角方向Q的冲突问题
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    //中间结果，即存放上一行保存的结果值，以列表的形式存储
    private List<String> ListBoard(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (char[] c : board) {
            ans.add(String.copyValueOf(c));
        }
        return ans;
    }

}












