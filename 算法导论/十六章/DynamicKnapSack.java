public class DynamicKnapSack {

    //动态规划
    public int[][] DynamicKnapSackDP(int weight, int[] win, int[] vin) {
        int len= win.length;
        int[][] dp=new int[len][weight+1];
        printResult(dp);// dp[i][j]表示在背包容量为j的情况下，前i件宝贝的最大价值
        for(int i = 1; i < len; i++) {
            for(int j = 1; j <= weight; j++) {
                if(win[i] <= j) {//如果背包装得下这第i件物品
                    // 和不放入该物品时同样达到该体积的最大价值比较，dp[i-1][j-win[i]]时的最好值加上这个价值，相当于dp[i-1][j-win[i]]时选了这个重量的物品
                    //  再和dp[i - 1][j]进行比较
                    dp[i][j]=Math.max(dp[i-1][j-win[i]]+vin[i],dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];//背包装不下，最大价值不变
            }
        }
        return dp;
    }


    //打印dp数组
    public void printResult(int[][] arr) {
        int row=arr.length;
        int col=arr[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++)
                System.out.print(arr[i][j] + "  ");
            System.out.println();
        }
        System.out.println("--------------------------------");
    }

    //打印选择的物品
    public void printSelect(int[][] arr,int weight, int[] w, int[] v)
    {
        System.out.print("选取最大物品价值是:"+arr[w.length-1][weight]+"\n");
        int i=arr.length-1;
        int j=weight;
        while (i>0)
        {
            //从最后一个元素开始找
            if (arr[i][j] == (arr[i - 1][j - w[i]] + v[i]))
            {
                System.out.println(i+":weight="+w[i]+", value="+v[i]);
                j -= w[i];
            }
            i--;
        }

    }

    public static void main(String[] args) {
        DynamicKnapSack knapsack = new DynamicKnapSack();
        int[] w = {0,2,2,6,5,4};
        int[] v = {0,6,3,5,4,6};
        int weight = 10;
        int[][] dp=knapsack.DynamicKnapSackDP(weight, w, v);
        knapsack.printResult(dp);
        knapsack.printSelect(dp,weight,w,v);

    }

}
