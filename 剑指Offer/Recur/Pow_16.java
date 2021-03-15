public class Pow_16 {
    //第一次写的过不了，好像是小数的整数次方有误差，还是说时间复杂度太高了。。。
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n<0) return 1/myPow(x,Math.abs(n));
        return x*myPow(x,n-1);
    }

    //二分将x^n=x^(2(n/2))，一直将n二分，最后时间复杂度就是O(lgn)
    public double myPow2(double x, int n) {
        if(x == 0) return 0;
        //int32 变量n∈[−2147483648, 2147483647]因此当n=−2147483648时执行n=−n 会因越界而赋值出错。解决方法是先将
        //n存入long变量b，后面用b操作即可。
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            //res记录结果
            if((b & 1) == 1) res *= x;
            //x记录n当前二进制位的x^(bi)
            x *= x;
            b >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Pow_16 sr = new Pow_16();
        System.out.println(sr.myPow(2,0));
        System.out.println(sr.myPow(2,10));
        System.out.println(sr.myPow(2,-2));
        System.out.println(sr.myPow(2.1,3));
        System.out.println(sr.myPow2(2,4));

        System.out.println(sr.myPow2(2.1,3));
//        System.out.println(sr.myPow(2.1,10));
//        System.out.println(sr.myPow(2,-2));
    }
}
