public class Fib_10 {

    //递归有很多重复子问题，leetcode会超时
    //1、明确函数功能
    public int fib(int n) {
        //2、递归出口：这里有两个
        if(n==0) return 0;
        if(n==1) return 1;
        //3、规律
        return fib(n-1)+fib(n-2);
    }

    //dp[i]表示第i项斐波那契数列的值，空间复杂度：O(n) 时间复杂度：O(n)
    public int fib2(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    //空间优化：因为只需要返回最后的fib(n),空间复杂度：O(1) 时间复杂度：O(n)
    public int fib3(int n) {
        //相当于三个指针了，a指向第一个，b指向第二个，sum指向第三个
        int a=0,b=1,sum;
        for(int i=0;i<n;i++){
            // 每次运算都取模 避免越界
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Fib_10 sr = new Fib_10();
        System.out.println(sr.fib(5));
        System.out.println(sr.fib2(5));
        System.out.println(sr.fib3(5));


    }
}
