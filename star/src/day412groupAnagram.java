import java.util.*;

/**
 * @ClassName day412groupAnagram
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-12 11:21
 * @Version 1.0
 */

public class day412groupAnagram {
    public List<List<String>> groupAnagram(String[] strs){

        //对字符串数组进行排序，将排序后的字符串数组作为哈希表的键，依次对比，判断是否匹配
        if (strs.length == 0)
            return new ArrayList();
        Map<String,List> map = new HashMap<String,List>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key))
                map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());



    }
}
