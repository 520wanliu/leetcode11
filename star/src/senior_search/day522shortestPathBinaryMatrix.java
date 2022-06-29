package senior_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName day522shortestPathBinaryMatrix
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-22 11:25
 * @Version 1.0
 */

public class day522shortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid){

        //只有起点和终点都为0时才可以走
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1){
            return -1;
        }

        int count = 0;   //计数器，步数

        //用向量表示其余八个方向
        int[] dx = {0,1,0,-1,1,1,-1,-1};
        int[] dy = {1,0,-1,0,1,-1,-1,1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        grid[0][0] = 1; //将走过的格子进行标记，便于选择最短的路

        while (!queue.isEmpty()){
            count++;
            for (int i = 0; i < queue.size(); i++) {
                //逐层搜索
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                //此时到达终点，返回
                if ((x == grid.length - 1) && (y == grid.length - 1)) {
                    return count;
                }

                for (int k = 0; k < 8; k++) {
                    int X = x + dx[k];
                    int Y = y + dy[k];
                    if(X >= 0 && X < grid.length && Y >= 0 && Y < grid.length && grid[X][Y] == 0){  // 加入下一层的数
                        queue.offer(new int[]{X,Y});
                        grid[X][Y] = 1;
                    }
                }
            }
        }
        return -1;
    }

    /*public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){  // 只有两端都是0才可以开始
            return -1;
        }
        int count = 0;
        int[] dx = {0,1,0,-1,1,-1,1,-1};
        int[] dy = {1,0,-1,0,1,-1,-1,1}; // 8个位置
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1; // 走过的标记为1，这样就可以走最短的了
        while(!queue.isEmpty()){ // 进入BFS
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++){ // 逐层搜索
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                if(x == n-1 && y == n-1){ // 到达终点就返回
                    return count;
                }
                for(int k = 0; k < 8; k++){
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    if(xx >= 0 && xx < n && yy >= 0 && yy < n && grid[xx][yy] == 0){  // 加入下一层的数
                        queue.offer(new int[]{xx,yy});
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }*/
}











