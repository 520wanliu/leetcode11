import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day401 {

    //题目一：判断是否为回文串
    //直接在原字符串中进行对比
  /*  public boolean isPalindrome(String s){
        //1、使用双指针前后对比，跳过当前指针位置的值不是数字或字母的位置
        int l = 0,r = s.length() - 1;
        while (l < r){
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
                r--;
            //2、将字符串中字母全部转化为小写，判断前后指针位置的值是否一致
            if (l < r){
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                    return false;
            }
        }
        return true;
    }*/
/*
    //双指针
    //1、找出字符串中的字母和数字，构成新的字符串str
    public boolean isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }
        //2、双指针前后比较当前位置的值是否相同，判断是否为回文串
        int l = 0, r = str.length() - 1;
        for (; l < r; l++, r--) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
        }
        return true;
    }*/
/*
    //自顶向下编程
    public boolean isPalindrome(String s) {

        //验证是否为回文串
        //1、过滤非字母和数字
        String filteredS =  _filteNonNumberAndChar(s);
        //2、字符串反转
        String reversedS = _reverseString(filteredS);

        //3、比较字符串，是回文串：返回true
        return reversedS.equalsIgnoreCase(filteredS);*//*

        //优化
        String filteredS = _filteNonNumberAndChar(s);
        return _reverseString(filteredS).equalsIgnoreCase(filteredS);

    }

    private String _reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String _filteNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]","");
    }
*/





    //题目二：三数之和
    //返回类型错误    （超出内存限制）
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length;){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        a.add(Arrays.asList(nums[i],nums[j],nums[k]));

                        while (nums[j] == nums[j + 1]) j ++;
                        while (nums[k] == nums[k + 1]) k ++;
                    }else if (nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    }else if (nums[i] + nums[j] + nums[k] < 0) k++;
                }
            }
        }
        return a;
    }

/*    public List<List<Integer>> threeSum(int[] nums) {

        //定义List对象，存放满足条件的三元组
        List<List<Integer>> str = new ArrayList<>();

        //判断当前数组长度是否满足三元组长度
        if (nums == null || nums.length < 3) return str;

        //对当前数组进行排序
        Arrays.sort(nums);

        //双指针循环寻找满足条件的三元组
        for (int i = 0; i < nums.length; i++){

            //如果 i 位置的元素值大于0，则第一个元素不满足条件，直接退出该循环，判断下一位置
            if (nums[i] > 0) break;

            //去重：i>0时，比较 i 位置元素值是否与 i-1 位置的元素值是否相同
            if (i > 0 && nums[i] ==nums[i - 1]) continue;

            //此时第一个三元组元素的值大小和去重已经确定结束
            //结合 i 位置元素用双指针前后判断三数之和是否为0
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    //将满足三数之和的元素存为列表形式，存入列表str对象中
                    str.add(Arrays.asList(nums[i],nums[l],nums[r]));

                    //l 和 r 位置元素去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (sum < 0) l++;
                else if (sum > 0) r--;
            }
        }
        return str;
    }*/
}
