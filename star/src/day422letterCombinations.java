import java.util.*;

/**
 * @ClassName testLenth
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-22 20:24
 * @Version 1.0
 */

public class day422letterCombinations {
    /*
    //递归 + 哈希表存储
    public static List<String> letterCombinations(String digits){
        //若当前字符串长度为0或者为空字符串
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        //将所有数字对应的字母以HashMap存储
        Map<Character,String> map = new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        //定义列表存储最终结果
        List<String> result = new LinkedList<String>();
        _letterCombinations("",digits,0,map,result);
        return result;
    }

    private static void _letterCombinations(String s, String digits, int level, Map<Character, String> map, List<String> result) {
        //terminal
        if (level == digits.length()){
            result.add(s);
            return;
        }

        //process
//        char letter = digits.charAt(level);
//        String letters = map.get(letter);
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            _letterCombinations(s+letters.charAt(i),digits,level + 1,map,result);
        }
    }*/

    //递归 + 哈希表 + 队列
    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        /*Map<Character, String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");*/
        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{    //存储为数组更好操作
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};

        //定义队列存储所有组合结果
        Queue<String> queue = new LinkedList<>();

        //遍历digits，取出数字对应的所有的字母数组
        for (int i = 0; i < digits.length(); i++) {
            _letterCombinations(queue,map.get(digits.charAt(i)));
        }

        //返回组成的所有字母组合的List列表
        for (String s : queue) {
            result.add(s);
        }

        return result;
    }

    private Queue<String> _letterCombinations(Queue<String> queue, String[] letters) {
        //若队列为空，将当前数字对应的所有字母添加至队列中
        if (queue.size() == 0){
            for (String letter : letters) {
                queue.add(letter);
            }
            return queue;
        }
        //队列不为空，将队列中字母依次取出，进行组合后在此进入队列
        for (int i = 0; i < queue.size(); i++) {
            String s = queue.poll();
            for (String letter : letters) {
                //对取出的字母进行组合，添加到队列中
                queue.add(s + letter);
            }
        }
        return queue;
    }


    /*public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        for (String i : strings) {
            System.out.println(i);
        }
    }*/
}
