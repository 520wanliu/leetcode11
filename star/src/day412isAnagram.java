import java.util.Arrays;

/**
 * @ClassName day412isAnagram
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-12 9:43
 * @Version 1.0
 */

public class day412isAnagram {
    public boolean isAnagram(String s,String t){
        //字母异位词：两字符串长度相同，字母相同，字母顺序不同

/*        //方法一：排序后比较字符串是否相等
//        1.若两个字符串长度不同，则直接返回false
        if (s.length() != t.length()) return false;
//        2.对两个字符串进行排序(1.转换成字符数组；2.数组排序)
        //toCharArray()：将字符串对象中的字符转换成一个字符数组
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
//        3.比较数组元素是否相同
        return Arrays.equals(chars1, chars2);*/


/*        //方法二：构建字母哈希表，遍历两个字符串，一个负责在对应位置增加，另一个负责在对应位置减少
//        1.若两个字符串长度不同，直接返回false
        if (s.length() != t.length()) return false;
//        2.构建字母哈希表，遍历字符串
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
//        3.若字母哈希表值不为0，返回false
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }*/
        return true;

    }
}
