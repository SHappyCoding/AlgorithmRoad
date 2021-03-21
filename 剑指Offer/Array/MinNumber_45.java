public class MinNumber_45 {
    public String minNumber(int[] nums) {
        //定义字符串数组
        String[] strs = new String[nums.length];
        //将整数转化为字符串
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        //内置函数自定义排序规则,如果x+y>y+x,那么y在最小数里面就应该在x的左边。这里就是基于字符串字典序比较
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)//拼接这个字符串数组即可
            res.append(s);
        return res.toString();
    }


    public static void main(String[] args) {
        MinNumber_45 mq = new MinNumber_45();
        int[] a={3,30,34,5,9};
        System.out.println(mq.minNumber(a));


    }
}
