public class LengthLIS_300 {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len < 2)return len;
        int[] dp=new int[len];
        int max=0;
        dp[0]=1;
        for(int i=1;i<len;i++){
            dp[i]=1; //当前nums[i]至少可以作为一个序列
            for(int j=i;j>=0;j--){
                if(nums[i]>nums[j])dp[i]=Math.max(dp[i],dp[j]+1);  //更新当前dp[i]
            }
            max = Math.max(max, dp[i]); //保存dp的最大值
        }
        return max;
    }

    //d[i]表示长度为 i 的最长上升子序列的末尾元素的最小值，此时dp数组是个单调数组
    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        //len表示了插入最长子序列的长度
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) { //末尾总是加一个比dp[len]大的
                d[++len] = nums[i];
            } else { //因为dp有序，可以用二分
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l < r) { //找到第一个比nums[i]小的数d[k]，更新d[k+1]=nums[i] ，比nums[i]小的右边界mid
                    int mid = (l + r + 1) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LengthLIS_300 sr=new LengthLIS_300();
        int[] a={10,9,2,5,3,7,101,18};
        System.out.println(sr.lengthOfLIS(a));
        System.out.println(sr.lengthOfLIS2(a));
    }

}
