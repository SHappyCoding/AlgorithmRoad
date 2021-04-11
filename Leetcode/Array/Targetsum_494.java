public class Targetsum_494 {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        recur(nums,0,target,0);
        return count;
    }

    public void recur(int[] nums,int i,int target,int sum){
        if(i==nums.length){
            if(sum==target)count++; //把两个if分开是因为i==nums.length条件是独立的
        }else{
            recur(nums,i+1,target,sum+nums[i]);
            recur(nums,i+1,target,sum-nums[i]);
        }
    }

    //dp[i][j]代表前i个元素，组成和为j的方案数
    public int findTargetSumWays3(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001]; //和可以是-1000到1000
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1; //nums[0]=0
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];  //+=表示：假设num[i]=1：-1+1=0，1-1=0，
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    //dp[i][...] 只和 dp[i - 1][...] 有关
    public int findTargetSumWays2(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }

    public static void main(String[] args) {
        Targetsum_494 sr=new Targetsum_494();
        int[] a={1,1,1,1,1};
        System.out.println(sr.findTargetSumWays(a,3));
        System.out.println(sr.findTargetSumWays2(a,3));
        System.out.println(sr.findTargetSumWays3(a,3));
    }
}
