public class knapsack {

    // w表示重量，v表示价值，W为背包容量
    // w，v下标从1开始
    public static int knap_01_1(int W,int[] w, int[] v) {
        int len=w.length;
        int[][] dp = new int[len][W+1];
        int wc,vc;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len-1][W];
    }

    public static int knap_01_2(int W,int[] w, int[] v) {
        int len=w.length;
        int[] dp = new int[W+1];
        int wc,vc;
        for (int i = 1; i < len; i++) {
            for (int j = W; j >= 1; j--) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] w={0,10,20,30};
        int[] v={0,60,100,120};
        System.out.print(knap_01_1(50,w,v)+"\n");
        System.out.print(knap_01_2(50,w,v));
    }

}
