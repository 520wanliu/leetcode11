import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName day429numIsLands
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-29 16:16
 * @Version 1.0
 */

public class day429numIsLands {
/*
    //深度优先遍历
    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) return 0;

        //获取网格的行和列
        int row = grid.length;
        int col = grid[0].length;;
        int num_island = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    ++num_island;
                    _dfsOfnumIslands(i,j,grid);
                }
            }
        }
        return num_island;
    }

    public void _dfsOfnumIslands(int row, int col, char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        //terminal
        if (row < 0 || col < 0 || row >= r || col >= c || grid[row][col] == '0')
            return;

        //process
        grid[row][col] = '0';

        //drill down
        _dfsOfnumIslands(row - 1, col, grid);
        _dfsOfnumIslands(row + 1, col, grid);
        _dfsOfnumIslands(row, col - 1, grid);
        _dfsOfnumIslands(row, col + 1, grid);
    }*/

    //广度优先遍历
    public int numIslands(char[][] grid){

        int numsOfIsland = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1'){
                    _bfsOfnumIslands(grid,row,col);
                     numsOfIsland ++;
                    }
                }
            }
        return numsOfIsland;
    }

    private void _bfsOfnumIslands(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] curLand = queue.poll();
            row = curLand[0];
            col = curLand[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
                grid[row][col] = '0';
                queue.add(new int[]{row - 1, col});
                queue.add(new int[]{row + 1, col});
                queue.add(new int[]{row, col - 1});
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
