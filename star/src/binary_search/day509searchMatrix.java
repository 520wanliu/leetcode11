package binary_search;

/**
 * @ClassName day509searchMatrix
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-09 10:13
 * @Version 1.0
 */

public class day509searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

/*        //二分查找：由于矩阵每行第一个数大于上一行最后一个数，
        // 则可以将其拼接起来构成一个升序数组，
        // 然后在计算时将升序数组的下标与矩阵的行和列进行对应即可
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int mid_map = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (target < mid_map){
                right = mid - 1;
            }else if (target > mid_map){
                left = mid + 1;
            }else return true;
        }
        return false;*/

        //将二维矩阵左旋转45度，当作一棵二叉树
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = col - 1;
        while (l >= 0 && l < row && r >= 0 && r < col){
            if (matrix[l][r] == target) return true;
            if (matrix[l][r] > target) r--;
            else l++;
        }
        return false;
    }
}
