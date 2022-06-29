package senior_search;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nqueens {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solvenqueens(int n){
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        _backTracking(n, board, 0);
        return answer;
    }

    private void _backTracking(int n, char[][] board, int row) {
        if (row == n){
            answer.add(ListBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            //处理节点——判断当前节点是否有效
            if (!valid(board, row, col, n)){
                continue;
            }
            //有效节点存放Q
            board[row][col] = 'Q';

            _backTracking(n, board, row + 1);

            board[row][col] = '.';
        }
    }

    private boolean valid(char[][] board, int row, int col, int n) {
        //处理每一列
        for (int i = 0; i < n; i++){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //处理45°角
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[row][col] == 'Q'){
                return false;
            }
        }
        //处理135°
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[row][col] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> ListBoard(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (char[] c : board) {
            ans.add(String.copyValueOf(c));
        }
        return ans;
    }

}




