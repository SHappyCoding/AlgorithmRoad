public class FindNthDigit_44 {
    //找规律，->立即推放弃
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.确定n所在数字的位数，记为digit
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.确定n所在的数字，记为num，start 为第 0 个数字，如果用n/digit，那就可能会忽略了start
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.确定n是num 中的哪一数位，并返回结果。这里取n-1使得num中各位的位置坐标从左到右从0开始增加，即0,1,....,(digit-1)
    }

    public static void main(String[] args) {
        FindNthDigit_44 mq = new FindNthDigit_44();
        System.out.println(mq.findNthDigit(300));

    }
}
