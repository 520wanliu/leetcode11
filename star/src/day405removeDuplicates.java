public class day405removeDuplicates {

    //双指针，后移指针覆盖元素
    //删除有序数组中重复项（26）
    public int removeDuplicates(int[] nums){
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] != nums[i + 1]){
                nums[++j] = nums[i + 1];
            }
        }
        return j + 1;
    }

    public void rotate(int[] nums,int k){

        //方法一：使用辅助数组
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; ++i){
            a[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(a,0,nums,0,nums.length);

        //方法二：对数组翻转：1.翻转整个数组；2.以 k 为分界点，数组的前后部分各自翻转
        k = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k, nums.length - 1);
    }

    //方法二的函数调用
    private void reverse(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
    }
}
