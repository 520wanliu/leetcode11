package senior_search;

/**
 * @ClassName day522solveSudu
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-22 9:40
 * @Version 1.0
 */


//回溯模板
    /*void backtracking(路径,选择列表){
        if(终止条件){
            存放中间结果;
            return;
        }

        for(本层集合元素处理){
            处理节点;
            backtracking(路径,选择元素);
            回溯，撤销节点处理;
        }
    }*/

public class day522solveSudu {

    /*//用三个布尔数组来标记行、列、块中的数字是否被使用，使用过标记为true，未使用过标记为false
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][][] blockUsed = new boolean[3][3][10];

    public void solveSudoku(char[][] board){

        //初始化有效数独棋盘
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int curNum = board[row][col] - '0';
                if (curNum >= 1 && curNum <= 9){
                    rowUsed[row][curNum] = true;
                    colUsed[col][curNum] = true;
                    blockUsed[row / 3][col / 3][curNum] = true;
                }
            }
        }
        _solveSudoku(board,0,0);
    }

    private boolean _solveSudoku(char[][] board, int row, int col) {

        //结束条件：遍历每行的列，直到所有的行遍历结束
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length)
                return true;
        }

        //递归主体：往方格中填入数字（若当前方格为空格，填入合适的数字）
        if (board[row][col] == '.') {
            for (int curnum = 1; curnum <= 9; curnum++) {

                //若当前方格中的数字没有被使用过，则将其标记为true，填入该数字到方格中，在递归遍历下一个方格
                if (!(rowUsed[row][curnum]) && !(colUsed[col][curnum]) && !(blockUsed[row / 3][col / 3][curnum])) {
                    //当前数字没有被使用过，即为false，开始使用该数字，则将其标记为true
                    rowUsed[row][curnum] = true;
                    colUsed[col][curnum] = true;
                    blockUsed[row / 3][col / 3][curnum] = true;

                    //将该数字填入当前方格中
                    board[row][col] = (char) ('0' + curnum);

                    //递归遍历下一方格
                    if (_solveSudoku(board, row, col + 1)) {
                        return true;
                    }

                    //回溯，撤销当前节点处理
                    board[row][col] = '.';
                    rowUsed[row][curnum] = false;
                    colUsed[col][curnum] = false;
                    blockUsed[row / 3][col / 3][curnum] = false;
                }
            }
        }else {
            return _solveSudoku(board, row, col + 1);
        }
        return false;
    }*/

    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][][] blockUsed = new boolean[3][3][10];
    public void solveSudoku(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                int curNum = board[i][j] - '0';
                if (curNum >= 1 && curNum <= 9){
                    rowUsed[i][curNum] = true;
                    colUsed[j][curNum] = true;
                    blockUsed[i / 3][j / 3][curNum] = true;
                }
            }
        }
        _solveSudoku(board, 0, 0);
    }

    private boolean _solveSudoku(char[][] board, int row, int col) {
        if (col == board[0].length){
            col = 0;
            row++;
            if (row == board.length){
                return true;
            }
        }

        if (board[row][col] == '.'){
            for (int curNum = 1; curNum <= 9; curNum++){
                if (!(rowUsed[row][curNum] && !(colUsed[col][curNum]) && !(blockUsed[row / 3][col / 3][curNum]))){
                    rowUsed[row][curNum] = true;
                    colUsed[col][curNum] = true;
                    blockUsed[row / 3][col / 3][curNum] = true;

                    board[row][col] = (char)('0' + curNum);

                    if (_solveSudoku(board, row, col + 1)){
                        return true;
                    }

                    board[row][col] = '.';
                    rowUsed[row][curNum] = false;
                    colUsed[col][curNum] = false;
                    blockUsed[row / 3][col / 3][curNum] = false;
                }
            }
        }else {
            return _solveSudoku(board,row,col + 1);
        }
        return false;
    }
}













