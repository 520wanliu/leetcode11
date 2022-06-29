import java.util.*;

/**
 * @ClassName day429ladderLength
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-29 8:48
 * @Version 1.0
 */

public class day429ladderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord))
            return 0;

        HashSet<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 0);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()){
//            System.out.println(queue);
//            String cur = queue.poll();
//            wordSet.remove(beginWord);

            for (int i = 0; i < queue.size(); i++) {

                String cur = queue.poll();
                wordSet.remove(beginWord);

                //修改cur中的一个字符，判断其是否与endWorld相同，返回map对应的位置
                char[] curCharArray = cur.toCharArray();

                for (int j = 0; j < curCharArray.length; j++) {
                    //中间变量存储字符数组中每一个字符
                    char originChar = curCharArray[i];
                    for (char k = 'a'; k <= 'z'; k++){
                        //若当前位置字符与待改变的字符一致，则跳过；否则将当前位置的字符进行修改
                        if (k == originChar){
                            continue;
                        }
                        curCharArray[i] = k;
                        String nextCurCharArray = new String(curCharArray);
                        if (wordSet.contains(nextCurCharArray)) {
                            map.put(nextCurCharArray, map.get(cur) + 1);
                            if (nextCurCharArray.equals(endWord))
                                return map.get(nextCurCharArray)+1;
                            if (!visited.contains(nextCurCharArray)){
                                queue.add(nextCurCharArray);
                                visited.add(nextCurCharArray);
                            }
                        }
                    }
                    //还原curCharArray[j]并进行下一个字母的搜索（因为只能改变一个字母）
                    curCharArray[j] = originChar;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] s = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(s);
        int i = ladderLength(begin, end, wordList);
        System.out.println(i);
    }
}

/*

class Solution {

//    总体思路:BFS
//    BFS是一圈一圈地进行扫描,因此可以在最先到达终点时计算出扫描的圈数,这个圈数就是最短路径长度
//    为了避免重复扫描,还需要一个容器来标记已经搜索过的节点

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // 存储字典中的单词+去重(List->Set)
    Set<String> wordSet = new HashSet<>(wordList);
    // 去除开始单词
    wordSet.remove(beginWord);
    // 若wordSet没包含endWord直接到达不了终点返回0
    if (!wordSet.contains(endWord)) {
        return 0;
    }
    // 辅助队列:初始化时加入开始单词
    Deque<String> que = new LinkedList<>() {{
        this.add(beginWord);
    }};
    // 标记已经搜索过的字符串
    Set<String> visited = new HashSet<>() {{
        add(beginWord);
    }};
    // 当前搜索过的层数(由于一开始就包含了开始的单词因此初始化为1)
    int step = 1;
    // 开启BFS
    while (!que.isEmpty()) {
        // size为当前层的节点数
        int size = que.size();
        for (int i = 0; i < size; i++) {
            // 弹出的节点(单词),以该节点为起点进行搜索
            char[] poll = que.poll().toCharArray();
            // 遍历poll的每个字母
            for (int j = 0; j < poll.length; j++) {
                // 记住原来的poll[j]处的字母以便还原
                char origin = poll[j];
                // 每个字母可改变范围为'a'-'z'
                for (int k = 'a'; k <= 'z'; k++) {
                    // 原来的可以跳过
                    if (k == origin) {
                        continue;
                    }
                    // 替换poll[j]为k
                    poll[j] = (char) k;
                    // 生成新单词
                    String newWord = String.valueOf(poll);
                    // 若wordSet中能找到newWord
                    if (wordSet.contains(newWord)) {
                        // 若newWord是终点,直接返回搜索节点总个数,此时的路径最短
                        if (newWord.equals(endWord)) {
                            // 由于序列中包含原本的单词,因此为step+1,试想一下
                            // 一开始第一轮就搜索到了,step后面才会加上,因此step=1,但是应该返回2才正确(begin+end)
                            return step + 1;
                        }
                        // newWord没到终点且未被搜索:继续搜索
                        if (!visited.contains(newWord)) {
                            // 加入队列,并马上标记为搜索过(避免同一层的节点被重复加入队列)
                            que.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
                // 还原poll[j]并进行下一个字母的搜索(因为只能改变一个字母)
                poll[j] = origin;
            }
        }
        // 一层节点搜索完毕,圈数+1
        step++;
    }
    // 最后搜不到endWord,返回0
    return 0;
}
}


*/