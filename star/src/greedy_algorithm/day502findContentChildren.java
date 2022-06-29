package greedy_algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName day502findContentChildren
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-02 21:49
 * @Version 1.0
 */

public class day502findContentChildren {
    /*public int findContentChildren(int[] g, int[] s){
        int maxcount = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; i++,j++) {
            while (j < s.length && g[i] > s[j]){
                j++;
            }
            if (j < s.length) {
                maxcount++;
            }
        }
        return maxcount;
    }*/
    /*public int findContentChildren(int[] g, int[] s){
        int maxcount = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (g[i] <= s[j]){
                    maxcount++;
                    s[j] = -1;
                    break;
                }
            }
        }
        return maxcount;
    }*/
    public int findContentChildren(int[] g, int[] s){
        int maxcount = 0;
        int temp = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = temp; j < s.length; j++) {
                if (g[i] <= s[j]){
                    maxcount++;
                    temp = j + 1;
                    break;
                }
            }
        }
        return maxcount;
    }

    public static void main(String[] args) {
//        int[] g = {10,9,8,7};
        int[] g = {1,2,3};
        int[] s = {1,1};
//        int[] s = {5,6,7,8};
        day502findContentChildren children = new day502findContentChildren();
        int i = children.findContentChildren(g, s);
        System.out.println(i);
    }
}
