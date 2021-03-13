public class NumWays_10_2 {

    //dp[i]：表示跳上i阶台阶的跳法
    public int numWays(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] =dp[1]= 1;
        for(int i = 2; i < n + 1; i++){
            //状态转移方程：dp[i] = dp[i - 1] + dp[i - 2]
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
    
    //空间优化输出最后一个值即可
    public int numWays2(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        NumWays_10_2 sr = new NumWays_10_2();
        System.out.println(sr.numWays(0));
        System.out.println(sr.numWays(3));
        System.out.println(sr.numWays(5));
        System.out.println(sr.numWays2(0));
        System.out.println(sr.numWays2(3));
        System.out.println(sr.numWays2(5));
    }
}
