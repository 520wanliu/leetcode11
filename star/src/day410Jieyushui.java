import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName day410Jieyushui
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-10 21:34
 * @Version 1.0
 */

public class day410Jieyushui {
    public int trap(int[] height){
        /*
        //动态规划的方法，使用数组存储左右区间的最大值，避免重复遍历

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        //存放存储雨水量的结果
        int result = 0;

        if (height == null || height.length == 0) return 0;

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--){
            right[i] = Math.max(height[i],right[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            result = result + Math.min(left[i],right[i]) - height[i];
        }
        return result;*/



        //单调栈
        Deque<Integer> stack = new LinkedList<Integer>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int temp = stack.pop();
                if (stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int high = Math.min(height[i],height[stack.peek()]) - height[temp];
                result += width * high;
            }
            stack.push(i);
        }
        return result;
    }
}












