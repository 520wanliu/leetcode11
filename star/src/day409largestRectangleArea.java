import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName day409largestRectangleArea
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-09 9:50
 * @Version 1.0
 */

public class day409largestRectangleArea {
    public int largestRectangleArea(int[] heights){
        //暴力破解法1：从左到右依次遍历
        /*for i -> 0,n-2
            for j -> i+1, n-2
                (i,j) -> 最小高度, area
                update max-area */
        /*int max_area = 0;
        for (int i = 0; i < heights.length; i++) {
            int minheight = Integer.MAX_VALUE;
            for (int j = i + 1; j < heights.length; j ++){
                int area = Math.min(heights[i], heights[j]) * (j - i + 1);
                max_area = Math.max(area,max_area);
            }
        }
        return max_area;*/

        //暴力破解法2：找左右边界（比其小的棒子） 超出时间限制
       /* for i -> 0, n-1
            找 left bound , right bound
            area = heights[i] * (right - left)
            update max-area*/
        /*int max_area = 0;
        for (int i = 0; i < heights.length; i++){
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++){
                minheight = Math.min(minheight, heights[j]);
                int area = minheight * (j - i + 1);
                max_area = Math.max(area,max_area);
            }
        }
        return max_area;*/

      /*  //往两边扩散寻找最矮边界   ：   超出时间限制
        if (heights.length == 0) return 0;
        int area = 0;
        //找左右边界
        for (int i = 0; i < heights.length; i++) {

            //找左边界：找第一个比当前棒子矮的棒子
            int left = i;
            while (left > 0 && heights[left - 1] >= heights[i]){
                left--;
            }

            //找右边界：找第一个比当前棒子矮的棒子
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]){
                right ++;
            }
            area = Math.max(heights[i] * (right - left + 1), area);
        }
        return area;
        */

        //栈的思想
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        Deque<Integer> stack = new ArrayDeque<Integer>();
        //判断当前棒子的左边，若左边的棒子低于当前棒子，将栈顶元素出栈，
        //将左边最小棒子存入左边数组中，并将左边最小值存入栈中
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        //清除当前栈，准备判断右边
        stack.clear();

        //判断当前棒子的右边，若右边的棒子低于当前棒子，将栈顶元素出栈，
        //将右边最小棒子存入右边数组中，并将右边最小值存入栈中
        for (int i = heights.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? heights.length : stack.peek());
            stack.push(i);
        }

        //计算当前符合棒子组成的面积
        int area = 0;
        for (int i = 0; i < heights.length; ++i) {
            area = Math.max(area, heights[i] * (right[i] - left[i] - 1));
        }
        return area;

    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1, 1};
        day409largestRectangleArea solution = new day409largestRectangleArea();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}
