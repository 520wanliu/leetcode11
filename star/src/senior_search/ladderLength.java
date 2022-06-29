package senior_search;

import java.util.*;

public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

       Set<String> wordSet = new HashSet<>(wordList);
       if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
       wordSet.remove(beginWord);

       Queue<String> queue = new LinkedList<>();
       queue.offer(beginWord);
       Set<String> visited = new HashSet<>();
       visited.add(beginWord);

       int step = 1;
       while (!queue.isEmpty()){
           int curSize = queue.size();
           for (int i = 0; i < curSize; i++) {
               String curWord = queue.poll();
               if (changeWordEveryOneLetter(wordSet, endWord, visited, curWord, queue)){
                   return step + 1;
               }
           }
           step++;
       }
       return 0;
    }

    private boolean changeWordEveryOneLetter(Set<String> wordSet, String endWord, Set<String> visited, String curWord, Queue<String> queue) {

        char[] charArray = curWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char origin = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == origin){
                    continue;
                }
                charArray[i] = j;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)){
                    if (nextWord.equals(endWord)){
                        return true;
                    }
                    if (!visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = origin;
        }
        return false;
    }
}
