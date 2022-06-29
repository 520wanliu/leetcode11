package senior_search;

import java.util.*;

public class minMutation {
    public int minMutation(String start, String end, String[] bank){
        if (bank == null || bank.length == 0){
            return -1;
        }

        char[] gen = {'A', 'C', 'G', 'T'};

        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);

        while (!queue.isEmpty()){
            String cur = queue.poll();
            bankSet.remove(cur);
            for (int i = 0; i < cur.length(); i++) {
                char[] next = cur.toCharArray();
                for (char c : gen) {
                    next[i] = c;
                    String nextCur = String.valueOf(next);
                    if (bankSet.contains(nextCur)){
                        map.put(nextCur, map.get(cur) + 1);
                        if (nextCur.equals(end)){
                            return map.get(nextCur);
                        }
                        queue.add(nextCur);
                    }
                }
            }
        }
        return -1;
    }
}





