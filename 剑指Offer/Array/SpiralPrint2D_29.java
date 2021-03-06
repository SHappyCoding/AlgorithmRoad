public class SpiralPrint2D_29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        //l-r代表列，t-b代表行,每周打印都在这个范围内
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        //每次打印一周的矩阵
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // 左->右.
            if(++t > b) break;//变到下一行，此时为了下一周准备，t应该缩小一圈
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // 上->下.
            if(l > --r) break;//变到左边一列，此时为了下一周准备，r应该缩小一圈
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // 右->左.
            if(t > --b) break;//变到上一行，此时为了下一周准备，b应该缩小一圈
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // 下->上.
            if(++l > r) break;//变到右边一列，此时为了下一周准备，l应该缩小一圈
        }
        return res;
    }
    public static void main(String[] args)
    {
        SpiralPrint2D_29 sr=new SpiralPrint2D_29();
        int[][] a=new int[][]{
                {1,   2,  3},
                {4,   5,  6},
                {7,   8,  9}};
        int[] el=sr.spiralOrder(a);
        for(int e:el){
            System.out.print(e+"  ");
        }

    }
}
