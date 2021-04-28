public class Sumnums_64 {
    private int res=0;
    //这里的res的递归是1+2+3+...+n
    public int sumNums(int n) {
        boolean b=n>1 && sumNums(n-1)>0;
        res+=n;
        return res;
    }

    public int sumNums2(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
    public static void main(String[] args) {
        Sumnums_64 s=new Sumnums_64();
        System.out.println(s.sumNums(10));
        System.out.println(s.sumNums2(2));
    }
}
