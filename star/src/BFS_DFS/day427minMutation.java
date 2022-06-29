import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName day427minMutation
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-27 8:46
 * @Version 1.0
 */

public class day427minMutation {
    /*public int minMutation(String start, String end, String[] bank) {
        //若基因库为空，无法实现目标变化
        if(bank == null || bank.length == 0) return -1;

        //将基因以数组形式存储
        char[] gen = {'A','C','G','T'};

        //将基因库中基因以哈希集合存储
        HashSet<String> bankset = new HashSet<>();
        for (String s : bank) {
            bankset.add(s);
        }

        //构建中间结果队列，对起始基因序列和目标基因序列进行操作，开始时先将起始基因序列入队
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        //对起始基因通过哈希map进行匹配操作
        HashMap<String, Integer> map = new HashMap<>();
        map.put(start, 0);

        //BFS操作
        while (!queue.isEmpty()){
            //获取队首元素
            String s = queue.poll();
            //上以西队列中所有的都需要出队，并进行下一次路径探索
            //队首元素与基因库中基因进行匹配，移除基因库中队首元素
            bankset.remove(s);
            for (int i = 0; i < s.length(); i++) {
                //toCharArray()方法：将字符串对象中的字符转化为字符数组
                char[] next = s.toCharArray();
                //将字符数组中的字符用对应的基因表示
                for (char c : gen) {
                    next[i] = c;
                    //将用基因表示的字符数组转化为字符串
                    String nextS = new String(next);
                    //若基因库集合中包含当前字符串，将其存入map中并与目标基因序列进行匹配
                    if (bankset.contains(nextS)){
                        map.put(nextS, map.get(s) + 1);
                        //当前字符串与目标基因匹配，满足需求，从map中获取最终基因码字符串
                        if (nextS.equals(end))
                            return map.get(nextS);
                        queue.add(nextS);
                    }
                }
            }
        }
        return -1;
    }*/

    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return -1;

        char[] gen = {'A','C','G','T'};

        HashSet<String> bankset = new HashSet<>();
        for (String s : bank){
            bankset.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        HashMap<String, Integer> map = new HashMap<>();
        map.put(start, 0);

        while (!queue.isEmpty()){
            String s = queue.poll();
            bankset.remove(s);

            for (int i = 0; i < s.length(); i++){
                char[] next = s.toCharArray();
                for (char c : gen) {
                    next[i] = c;
                    String nextS = new String(next);
                    if (bankset.contains(nextS)) {
                        map.put(nextS, map.get(s) + 1);
                        if (nextS.equals(end))
                            return map.get(nextS);
                        queue.add(nextS);
                    }
                }
            }
        }
        return -1;
    }
}









