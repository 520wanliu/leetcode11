import java.util.LinkedList;

/**
 * @ClassName day409maxSlidingWindow
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-09 12:27
 * @Version 1.0
 */

public class day409maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums,int k) {

        /*//暴力解法  超出时间范围
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j <= i + k - 1; j++){
                if (nums[j] > max){
                    max = nums[j];
                }
            }
            arr[i] = max;
        }
        return arr;
*/

        //双端队列：构造递减队列，若离开窗口的数等于队头则出队
        if (nums ==null || nums.length < 2) return nums;
        //定义一个新数组，存放最大值
        int[] arr = new int[nums.length - k + 1];

        //双向队列：保存当前窗口最大值的数组位置，使得队列中数组位置的数值按照从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //若此时队列不空，且当前元素 大于等于 队尾元素，将队尾元素移除
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            //若队列为空或当前元素小于队尾元素，将当前元素添加至队尾，构造单调减队列
            queue.addLast(i);

            //判断当前队列中队首元素的下标是否在滑动窗口内，若不在，移除队首元素
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            //若当前位置大于等于窗口大小时，保存当前窗口中最大值
            if (i + 1 >= k) {
                arr[i - k + 1] = nums[queue.peekFirst()];

            }
        }
        return arr;
    }
}
