import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName day417generateParenthesis
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-17 12:13
 * @Version 1.0
 */

public class day417generateParenthesis {

    private List<String> result;

    public List<String> generateParenthesis(int n){
        result = new ArrayList<String>();
//        _gengrate(0, 2 * n, "");
        _gengrate(0,0,n,"");
        return result;
    }

/*    //初版递归方法编写：没有考虑括号的合法性，运行结果大多不合法
    private void _gengrate(int level, int max, String s) {
        //递归步骤
        //1.递归结束条件
        if (level >= max){
            System.out.println(s);
            return;
        }
        //2.当前层的逻辑处理(将左右括号添加到数组中)
//        String s1 = s + "(";
//        String s2 = s + ")";
        //3.下探到下一层(递归遍历每层，即递归遍历每个左右括号)
        _gengrate(level + 1, max, s + "(");
        _gengrate(level + 1, max, s + ")");
        //4.清理当前状态*/

    //第二版递归方法的编写：考虑括号的合法性，添加左右括号的判断
    private void _gengrate(int left, int right, int n, String s) {
        //递归结束条件
        if (left == n && right == n){
            result.add(s);
            return;
        }
        //递归遍历每层，即递归遍历每个左右括号
        if (left < n)
            _gengrate(left + 1, right, n, s + "(");
        if (right < left)
            _gengrate(left, right + 1, n, s + ")");
    }

    public static void main(String[] args) {
        day417generateParenthesis sol = new day417generateParenthesis();
        System.out.println(sol.generateParenthesis(3));
    }
}
