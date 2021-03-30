public class ConstructArr_66 {

    //空间换时间
    public int[] constructArr(int[] a) {
        int len=a.length;
        if(len==0)return new int[0];
        int[] res =new int[len];
        //lres[i]存a[1,2...i]乘积
        int[] lres=new int[len];
        //rres[i]存a[i,i+1,i+2...n]乘积
        int[] rres=new int[len];
        lres[0]=a[0];
        rres[len-1]=a[len-1];
        for(int i=1;i<len;i++)lres[i]=lres[i-1]*a[i];
        for(int i=len-2;i>=0;i--)rres[i]=rres[i+1]*a[i];
        res[0]=rres[1];res[len-1]=lres[len-2];
        //res[i]=lres[i-1]*rres[i+1]
        for(int i=1;i<=len-2;i++)res[i]=lres[i-1]*rres[i+1];
        return res;
    }

    //两次循环
    public int[] constructArr2(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        //第一遍循环b[i]存a[1,2...i-1]乘积
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //第二遍循环从后往前，用temp存存a[i+1,i+2...n]乘积，然后b[i]加上即可
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        //最后b[i]=a[1,2...i-1]乘积+a[i+1,i+2...n]乘积。
        return b;
    }

    public static void main(String[] args) {
        ConstructArr_66 mq = new ConstructArr_66();
        int[] a={1,2,3,4,5};
        int[] b=mq.constructArr(a);
        for(int e:b){
            System.out.printf(e+" ");
        }
    }
}
