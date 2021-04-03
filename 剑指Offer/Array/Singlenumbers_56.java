public class Singlenumbers_56 {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        //全体异或结果res=a^b,那两个只出现一次的数
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        //找到res结果中任意为1的位i，记为di，表示ai和bi不等
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        //将数组分为两组，di=1,和di异或为0的一组，和di异或为1的分为一组，此时相同的数可坑定在相同的组抵消掉了
        //对于假设ai=1，bi=0，此时ai^1=0,bi^1=1;此时也将两个出现一次的数分在两个不同的组，最后结果坑定是一个a，一个b
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args)
    {
        Singlenumbers_56 sr=new Singlenumbers_56();
        int[] a={4,1,4,6};
        int[] b=sr.singleNumbers(a);
        for(int e:b){
            System.out.println(e+" ");
        }

    }
}
