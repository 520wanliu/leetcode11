public class day325 {
    //盛最多水的容器———两边夹逼思想
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0, j = height.length - 1; i < j; ){
            int Area = (j - i) * (height[i] < height[j] ? height[i ++] : height[j --]);
            maxArea = Math.max(maxArea,Area);
        }
        return maxArea;
    }

    //盛最多水的容器———暴力破解(时间复杂度超出运行时间范围）
    public int maxArea1(int[] height){
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for(int j = i + 1; j < height.length; ++j){
                int Area = (j - i) * Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,Area);
            }
        }
        return maxArea;
    }

    //移动0———单指针，与非0元素交换
    public void moveZeroes(int[] a) {
        for(int r = 0,l = 0; r < a.length; ++r){
            if (a[r] != 0){
                int temp = a[r];
                a[r] = a[l];
                a[l] = temp;
            }
            l++;
        }
    }
    //移动0———统计非0元素
    public void moveZeros1(int[] a){
        int j = 0;
        int i = 0;
        while(i < a.length)
        for (int k = j; k < a.length; k ++){
            a[k] = 0;
        }
    }

    //爬楼梯
    public int climStairs(int n){
        int f1 = 1, f2 = 2;
        int f3;
        for (int i = 2; i < n; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    public int climbStair(int n){
        int m = 0, t = 0, p = 1;
        for (int i = 0; i < n - 1; i ++){
            m = t;
            t = p;
            p = m + t;
        }
        return p;
    }

    //递归爬楼梯（时间复杂度超出运行时间范围）
    public int climStairs1(int n){
        if (n <= 1) return 1;
        else {
            return climStairs1(n - 1) + climStairs1(n - 2);
        }
    }


}