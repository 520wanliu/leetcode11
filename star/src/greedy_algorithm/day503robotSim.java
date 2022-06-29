package greedy_algorithm;

import java.util.HashSet;

/**
 * @ClassName day503robotSim
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-03 10:30
 * @Version 1.0
 */

public class day503robotSim {
    public int robotSim(int[] commands, int[][] obstacles){

        int result = 0;

        //定义机器人行走方向
        int[] dirX = {0,1,0,-1};
        int[] dirY = {1,0,-1,0};

        //定义机器人初始位置
        int initX = 0, initY = 0;

        //用来表示机器人的方向
        int curdir = 0;

        //利用哈希表来存储障碍物位置
        HashSet<String> obstacleSet = new HashSet<String>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2){  //左转90°，从y轴正方向顺时针旋转270°
                curdir = (curdir + 3) % 4;
            }
            if (commands[i] == -1){  //右转90°，从y轴正方向顺时针旋转90°
                curdir = (curdir + 1) % 4;
            }
            if (commands[i] > 0){    //直走：向前移动 x 个单位长度
                //一步一步试探当前commands[i]的步数是否可以全部走完
                for (int j = 0; j < commands[i]; j++) {
                    //机器人前进一步
                    int nextX = initX + dirX[curdir];
                    int nextY = initY + dirY[curdir];
                    //若当前位置有障碍，结束，
                    if (obstacleSet.contains(nextX + "," + nextY)) break;
                    initX = nextX;
                    initY = nextY;
                    //记录结果
                    result = Math.max(result,initX * initX + initY * initY);
                }
            }
        }
        return result;
    }
}
