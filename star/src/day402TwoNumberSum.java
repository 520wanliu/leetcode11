import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day402TwoNumberSum{
    public int[] twoSum(int[] nums, int target){

        //双重循环依次遍历，判断两数之和的值是否等于target
        /*for (int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    //以列表形式返回满足条件的二元组
                    return new int[]{i,j};
                }
            }
        }
        return null;*/


       /* //双指针前后遍历，判断是否满足条件
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if (nums[i] + nums[j] == target){
                return new int[]{i,j};
            }
            ++i;
            --j;
        }
        return null;*/


        //二分查找法求两数之和
        for (int i = 0; i < nums.length; ++i) {
            int l = i;
            int h = nums.length - 1;
            while (l <= h) {
                int mid = (h - l) / 2 + l;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    h = mid - 1;
                } else l = mid + 1;
            }
        }
        return null;
    }
}
