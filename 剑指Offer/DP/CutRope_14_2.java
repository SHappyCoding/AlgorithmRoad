public class CutRope_14_2 {
    //贪心也是得到更多的3
    public int cuttingRope2(int n) {
        if(n < 4)return n - 1;
        long res = 1L;
        while(n > 4){
            res = res * 3 %1000000007;
            n -= 3;
        }
        return (int)(res*n%1000000007);
    }



    public static void main(String[] args)
    {
        CutRope_14 sr=new CutRope_14();

        //System.out.println(sr.cuttingRope2(10));
        System.out.println(sr.cuttingRope3(120));
    }
}
