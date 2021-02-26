public class Arrry_413 {
    //dp[i] 代表[0，i]数组的等差数列个数，dp[i]=dp[i-1]+num，num是A[i]和前面的数构成等差数列数列的个数。
    public static int numberOfArithmeticSlices(int[] A) {
        int len=A.length;
        if(len<3)return 0;
        //int[] dp=new int[len];
        int d1,d2,count=0;
        for(int i=2;i<len;i++){
            //count=0;
            for(int j=i;j>=2;j--){
                d1=A[j]-A[j-1];
                d2=A[j-1]-A[j-2];
                if(d1==d2)count++;
                else break;
            }
            //dp[i]=dp[i-1]+count;
        }
        return count;
    }
    //空间优化，由于只需要返回整个数组的等差数组个数，只需要一个数记住总的个数即可
    public static int numberOfArithmeticSlices2(int[] A) {
        int len=A.length;
        if(len<3)return 0;
        int d1,d2,count=0;
        for(int i=2;i<len;i++){
            for(int j=i;j>=2;j--){
                d1=A[j]-A[j-1];
                d2=A[j-1]-A[j-2];
                if(d1==d2)count++;
                else break;
            }
        }
        return count;
    }
    //时间优化：dp[i]代表以i结尾的等差数列个数。
    //如果A[i-2],A[i-1],A[i]能构成一个等差数列那么dp[i]=1+dp[i-1]
    //那么整个数组的等差数列个数为dp数组元素之和
    public static int numberOfArithmeticSlices3(int[] A) {
        int len=A.length;
        if(len<3)return 0;
        int[] dp=new int[len];
        int d1,d2,count=0;
        for(int i=2;i<len;i++){
            d1=A[i]-A[i-1];
            d2=A[i-1]-A[i-2];
            if(d1==d2){
                dp[i]=1+dp[i-1];
                count+=dp[i];
            }
        }
        return count;
    }
    //时间优化之后空间再优化：我们只需要一个变量保存dp[i-1]的值就可以
    public static int numberOfArithmeticSlices4(int[] A) {
        int len=A.length;
        if(len<3)return 0;
        int dp=0;
        int d1,d2,count=0;
        for(int i=2;i<len;i++){
            d1=A[i]-A[i-1];
            d2=A[i-1]-A[i-2];
            if(d1==d2){
                dp=1+dp;
                count+=dp;
            }else dp=0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num={1,2,3,8,9,10};
        System.out.print(numberOfArithmeticSlices(num));
    }
}
