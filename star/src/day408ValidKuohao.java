import java.util.Stack;

/**
 * @ClassName day408ValidKuohao
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-08 8:29
 * @Version 1.0
 */

public class day408ValidKuohao {
    public boolean isValid(String s){
/*
        //方法一：普通入栈出栈
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            //将左括号直接入栈
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if (!stack.isEmpty()){
                //若是右括号，且栈不为空，若出栈元素不是对应左括号，返回false
                if (c == ')'){
                    if (stack.pop() != '('){
                        return false;
                    }
                }else if (c == '}'){
                    if (stack.pop() != '{'){
                        return false;
                    }
                }else if (c == ']'){
                    if (stack.pop() != '['){
                        return false;
                    }
                }
            }else {
                //若此时栈为空，但来一个右括号，直接返回false
                return false;
            }
        }
        return stack.isEmpty();
*/


        //方法二：
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.empty() || c != stack.pop()){
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}





















