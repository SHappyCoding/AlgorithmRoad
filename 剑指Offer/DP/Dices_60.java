public class Dices_60 {

    //map记录点数和，出现的次数
    Map<Integer,Double> map=new HashMap<>();
    public double[] dicesProbability(int n) {
        recur(n,0);
        int len=map.size(),i=0;
        double[] res=new double[len];
        int[] key=new int[len];
        double sum=Math.pow(6,n);
        for(Integer e : map.keySet()){
            key[i++]=e;
        }
        Arrays.sort(key);
        for(int e:key){
            System.out.print(e+" ");
        }
        for(i=0;i<len;i++){
            res[i]=map.get(key[i])/sum;
        }
        //Arrays.sort(res);
        System.out.println();
        for(Map.Entry e: map.entrySet()){
            System.out.print(e.getKey()+"  "+e.getValue()+" | ");
        }
        System.out.println();
        return res;
    }

    //摇过的骰子的和
    public void recur(int n,int sum){
        if(n==0){
            if(map.containsKey(sum))map.put(sum,map.get(sum)+1.0);
            else map.put(sum,1.0);
        }else{
            for(int i=1;i<7;i++){
                recur(n-1,sum+i);
            }
        }
    }

    //dp[i][j] 表示投掷完i枚骰子后，点数j的出现次数。
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = i; j <= 6 * i; j++) //第i个骰子出现后，可能出现的点数和
                for(int k = 1; k <= 6 && k <= j; k++)  //k表示当前骰子的点数
                    dp[i][j] += dp[i-1][j - k];  //转移方程

        double[] ans = new double[6 * n -n + 1]; //n骰子出现的点数和个数=6n-1n=5n
        double all=Math.pow(6,n);
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = (double)dp[n][i] / all;
        return ans;
    }

    //空间优化，每个阶段值和他前一个阶段的状态有关,j从大到小遍历
    public double[] twoSum3(int n) {
        int[] dp = new int[6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[i] = 1;
        for(int i = 2; i <= n; i++)
            for(int j = 6 * i; j >= i; j--) { //第i个骰子出现后，可能出现的点数和
                dp[j] = 0;  //从后往前逐个累加，在加到当前点数时，必须把原先存放的n-1个骰子的数据置0，否则累加出错。
                for (int k = 1; k <= 6; k++) {  //k表示当前骰子的点数
                    if (j - k < i - 1) break; //n-1个骰子的最小值就是n-1，不会比这再小
                    dp[j] += dp[j - k];  //转移方程
                }
            }
        double[] ans = new double[6 * n -n + 1]; //n骰子出现的点数和个数=6n-1n=5n
        double all=Math.pow(6,n);
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = (double)dp[i] / all;
        return ans;
    }

    //dp正向推
    public double[] dicesProbability2(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0); //第一个骰子，每个和出现的概率都是1/6
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) { //当前dp每个元素对下个tmp个元素有影响
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp; //dp重新指向了新的数组
        }
        return dp;
    }

    public static void main(String[] args) {
        Dices_60 sr=new Dices_60();
        double[] res=sr.dicesProbability(2);
        for(double e:res){
            System.out.print(e+" ");
        }
    }
}
