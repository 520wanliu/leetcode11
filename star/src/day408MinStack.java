import java.util.Stack;

/**
 * @ClassName day408MinStack
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-08 10:52
 * @Version 1.0
 */

public class day408MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    //构造，初始化数据结构
    public day408MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
