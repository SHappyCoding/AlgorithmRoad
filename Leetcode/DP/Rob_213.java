public class Rob1_213 {
    public static int rob(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
        int m1=rob2(nums,0,len-2);
        int m2=rob2(nums,1,len-1);
        return Math.max(m1,m2);
    }
    public static int rob2(int[] nums,int i,int j) {
        int p1=0,p2=0,cur=0;
        for(int k=i;k<=j;k++){
            cur=Math.max(p1+nums[k],p2);
            p1=p2;
            p2=cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] num={1,2,3,1};
        System.out.print(rob(num));
    }
}
