package BFS_DFS;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * @ClassName day430updateBoard
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-30 10:04
 * @Version 1.0
 */

public class day430updateBoard {

    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click){

        int x = click[0];
        int y = click[1];

        //情况一：如果挖出一个地雷，直接将‘M’改变为‘X’
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }else
            //其他情况：根据周围是否有地雷，递归判断其余方块
            _dfsupdateBoard(board,x,y);
        //情况四：没有更多盘面被挖掘，扫雷结束返回盘面
        return board;
    }

    private void _dfsupdateBoard(char[][] board, int x, int y) {

        int count = 0;

        //统计盘面的地雷个数
        for (int i = 0; i < 8; i++) {
            int row = x + dirX[i];
            int col = y + dirY[i];

            //判断当前方块是否在盘面内
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length){
                continue;
            }

            //若当前方块是未挖出的地雷，统计地雷个数
            if (board[row][col] == 'M'){
                ++count;
            }
        }
        //情况三：如果周围有地雷，表示附近有被找到的方块，此时讲该位置赋值为地雷个数
        if (count > 0){
            board[x][y] = (char) (count + '0');
        }else {
            //情况二：周围没有地雷，递归判断周围八个方块是否被挖掘
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                //递归判断周围八个方块
                int row = x + dirX[i];
                int col = y + dirY[i];
                //递归终结条件：当前方块在盘面内并且当前方块已经被挖掘
                if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E'){
                    continue;
                }
                _dfsupdateBoard(board, row, col);
            }
        }
    }

    public static void main(String[] args) {
        char[][]  c = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        day430updateBoard saolei = new day430updateBoard();
        int[] i = {3,0};
        char[][] chars = saolei.updateBoard(c, i);
        for (char[] aChar : chars) {
            System.out.println(aChar);
        }
    }
}
