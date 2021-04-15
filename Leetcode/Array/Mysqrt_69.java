public class Mysqrt_69 {
    //二分，时间复杂度:O(lgn)
    public int mySqrt(int x) {
        if(x==0)return x;
        int l=1,r=x,ans=1;
        while(l<r){ //找<=x的右边界
            int mid=l+1+(r-l>>1);
            if((long)mid*mid<=x){ //mid*mid可能会越界，当x取Integer.MAX_VALUE
                ans=mid;
                l=mid;
            }else r=mid-1;
        }
        return ans;
    }

    //公式：根号x=e^(0.5*lnx)
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        Mysqrt_69 sr=new Mysqrt_69();
        System.out.println(sr.mySqrt(4));
    }
}
