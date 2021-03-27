public class MaxProfit_63 {

    public int maxProfit(int[] prices) {
        int len=prices.length;
        int min=Integer.MAX_VALUE,maxpro=0;
        for(int i=0;i<len;i++){
            //min保存了price[0:i]的最小值
            min=Math.min(min, prices[i]);
            maxpro=Math.max(prices[i]-min,maxpro);
        }
        return maxpro;
    }

    public static void main(String[] args)
    {
        MaxProfit_63 sr=new MaxProfit_63();
        int[] p1={7,1,5,3,6,4};
        int[] p2={7,6,4,3,1};
        System.out.println(sr.maxProfit(p1));
        System.out.println(sr.maxProfit(p2));
    }
}
