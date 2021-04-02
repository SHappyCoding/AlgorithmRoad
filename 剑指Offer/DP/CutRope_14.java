public class CutRope_14 {

    //数学推导出切更多的3
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
    //贪心也是得到更多的3
    public int cuttingRope2(int n) {
        if(n < 4)return n - 1;
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    //动态规划
    //dp[i]表示长度为i的绳子，剪成m段后的最大乘积，
    public int cuttingRope3(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            //从n剪一段绳子的长度为j
            for(int j = 2; j < i; j++){
                //剪了j之后继续剪，和不剪了进行比较
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]))%(1000000007);
            }
        }
        return dp[n];
    }



    public static void main(String[] args)
    {
        CutRope_14 sr=new CutRope_14();

        System.out.println(sr.cuttingRope2(10));
        System.out.println(sr.cuttingRope3(120));
    }
}
