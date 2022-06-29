package senior_search;

/**
 * @ClassName day521shudu
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-21 8:20
 * @Version 1.0
 */

public class day521shudu {
    public boolean isValidSudoku(char[][] board) {
        /*//二维数字存储行、列、块的值，默认情况下每行、每列、每块中每一个数都没有出现过
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];

        //从左到右，从上到下遍历棋盘上每一个数
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int curNum = board[i][j] - '0' - 1;

                //判断当前数在其所在的行、列、块中是否出现过
                if (row[i][curNum] == 1 || col[j][curNum] == 1 || block[(i / 3) * 3 + (j / 3)][curNum] == 1)
                    return false;

                //若当前数之前没有出现过，现在出现了，就将其标记为1，方便下次遇见直接返回false
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                block[(i / 3) * 3 + j / 3][curNum] = 1;
            }
        }
        return true;*/

        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int curNum = board[i][j] - '0' - 1;
                if (row[i][curNum] == 1 || col[j][curNum] == 1 || block[(i / 3) * 3 + (j / 3)][curNum] == 1){
                    return false;
                }
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                block[(i / 3) * 3 + (j / 3)][curNum] = 1;
            }
        }
        return true;
    }
}
