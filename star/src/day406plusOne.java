public class day406plusOne {
    public int[] plusOne(int[] digits){
        for (int i = digits.length - 1; i >= 0 ; i--) {
            //从数组最后一个元素开始，给每个元素加 1 再对 10 求余.
            // 若结果为0，则需要进位，若不为0，则直接返回当前数字
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        //判断特殊情况：99,999……
        //扩容当前数组，长度为：digits.length + 1
        digits = new int[digits.length + 1];
        //给扩容后数组最高位，即第一个元素赋值为1，其余为0，返回数字
        digits[0] = 1;
        return digits;
    }
}
