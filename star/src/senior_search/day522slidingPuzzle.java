package senior_search;

import java.util.*;

/**
 * @ClassName day522slidingPuzzle
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-22 16:31
 * @Version 1.0
 */

public class day522slidingPuzzle {

/*
    //定义2*3数组中每个数字的邻接位置
    int[][] neighber = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

    public int slidingPuzzle(int[][] board){

        //获取初始状态的2*3数组
        StringBuffer bb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                bb.append(board[i][j]);
            }
        }
        //将原始数组转换成字符形式，如果原始数组一开始就是对的，则直接返回
        String init = bb.toString();
        if ("123450".equals(init)){
            return 0;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(init);
        Set<String> used = new HashSet<String>();
        used.add(init);
        while (!queue.isEmpty()){
            ++step;
            for (int i = 0; i < queue.size(); ++i) {
                String curstatus = queue.poll();
                for (String nextstatus : get(curstatus)) {
                    //若当前的数组 不包含 由当前状态通过一次交换得到的状态，且交换后的状态
                    if (!used.contains(nextstatus)){
                        if ("123450".equals(nextstatus))
                            return step;
                        queue.offer(nextstatus);
                        used.add(nextstatus);
                    }
                }
            }
        }
        return -1;
    }

    //indexOf(String str): 返回指定字符str在字符串中（方法调用者）第一次出现处的起始索引，如果此字符串中没有这样的字符，则返回 -1
    //indexOf(String str, int index): 返回从 index 位置开始查找指定字符str在字符串中第一次出现处的起始索引，如果此字符串中没有这样的字符，则返回 -1。
    //枚举curstatus通过一次交换操作得到的状态
    private List<String> get(String curstatus) {
        List<String> ret = new ArrayList<String>();
        char[] array = curstatus.toCharArray();
        int x = curstatus.indexOf('0');
        for (int y : neighber[x]) {
            swap(array,x,y);
            ret.add(new String(array));
            swap(array,x,y);
        }
        return ret;
    }

    private void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
*/

   int[][] neighbors = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

   public int slidingPuzzle(char[][] board){

       StringBuffer bb = new StringBuffer();
       for (int i = 0; i < 2; i++) {
           for (int j = 0; j < 3; j++){
               bb.append(board[i][j]);
           }
       }
       String init = bb.toString();
       if ("123450".equals(init))
           return 0;

       int step = 0;
       Queue<String> queue = new LinkedList<>();
       queue.add(init);
       Set<String> used = new HashSet<>();
       used.add(init);
       while (!queue.isEmpty()){
           step++;
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               String curstatus = queue.poll();
               for (String nextstatus : get(curstatus)){
                   if (!used.contains(nextstatus))
                       if ("123450".equals(nextstatus))
                           return step;
                       queue.add(nextstatus);
                       used.add(nextstatus);
               }
           }
       }
       return -1;
   }

    private List<String> get(String curstatus) {
       List<String> list = new ArrayList<>();
        char[] array = curstatus.toCharArray();
        int x = curstatus.indexOf('0');
        for (int y : neighbors[x]){
            swap(array, x, y);
            list.add(new String(array));
            swap(array, x, y);
        }
        return list;
    }

    private void swap(char[] array, int x, int y) {
       char temp = array[x];
       array[x] = array[y];
       array[y] = temp;
    }
}




