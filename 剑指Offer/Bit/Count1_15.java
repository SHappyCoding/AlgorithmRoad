public class Count1_15 {
    //时间复杂度：O(lgn) 也就是n的二进制位数
    public int hammingWeight(int n) {
         int count=0;
        while(n != 0) {
            count += n & 1;
            n >>>= 1;   //无符号数用>>>来移位
        }
         return count;
    }
    public int hammingWeight2(int n) {
        //直接返回一个数二进制数1的个数
        return Integer.bitCount(n);
    }

    //时间复杂度：O(M) M为1的个数
    public int hammingWeight3(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;//每次可以消掉n最右边的1
        }
        return res;
    }

    public static void main(String[] args)
    {
        Count1_15 sr=new Count1_15();
        System.out.println(sr.hammingWeight(2304));
        System.out.println(sr.hammingWeight2(5));


        System.out.println(sr.hammingWeight3(10));
    }
}
