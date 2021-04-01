public class UglyNumber_49 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        //dp[i]表示第i+1个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            //丑数=某较小丑数乘以某因子，找最小的才能不漏找
            dp[i] = Math.min(Math.min(n2, n3), n5);
            //更新abc下标
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    //这种方法超出了时间限制
    public int nthUglyNumber2(int n) {
        if(n==1)return 1;
        n--;
        int i=1,a,b,c;
        while(n>0){
            i++;
            a = recur(i,2);
            b=recur(a,3);
            c=recur(b,5);
            if(a==1 || b==1 || c==1){
                n--;
            }
        }
        return i;
    }
    public int recur(int n,int i){
        while(n%i==0)n/=i;
        return n;
    }



    public static void main(String[] args) {
        UglyNumber_49 sr=new UglyNumber_49();
        System.out.println(sr.nthUglyNumber(10));
        System.out.println(sr.nthUglyNumber(11));
        System.out.println(sr.nthUglyNumber(12));
        System.out.println(sr.nthUglyNumber(13));
        System.out.println(sr.nthUglyNumber(14));
        System.out.println(sr.nthUglyNumber(18));
        System.out.println(sr.nthUglyNumber2(18));
    }
}
