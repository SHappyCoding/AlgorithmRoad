public class Numtrees_96 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {  //以不同结点为根
                G[i] += G[j - 1] * G[i - j];    //G[i] +=F(i,n)
            }
        }
        return G[n];
    }

    //卡特兰数
    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
    public static void main(String[] args) {
        Numtrees_96 sr=new Numtrees_96();

        System.out.print(sr.numTrees(6));
    }
}
