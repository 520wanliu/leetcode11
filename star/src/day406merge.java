import java.util.Arrays;
import java.util.Scanner;

public class day406merge {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        /*
        //连接两个数组，在对合并后数组进行排序
        for (int i = 0; i < n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);*/

        //借用辅助数组，数组元素比较后添加至新数组，最后贴回原数组中
        int[] arr = new int[m + n];
        int p = 0, q = 0;
        int index;
        while (p < m || q < n){
            if (p == m) {
                index = nums2[q++];
            } else if (q == n) {
                index = nums1[p++];
            } else if (nums1[p] < nums2[q]) {
                index = nums1[p++];
            } else {
                index = nums2[q++];
            }
            arr[p + q - 1] = index;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }
}
