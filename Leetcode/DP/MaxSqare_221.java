public class MaxSqare_221 {
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length,col=matrix[0].length,max=0;
        int[][] dp=new int[row][col];
        for(int i=0;i<row;i++) {
            dp[i][0] = matrix[i][0] - '0';
            max=Math.max(max,dp[i][0]*dp[i][0]);
        }
        for(int j=1;j<col;j++){
            dp[0][j]=matrix[0][j]-'0';
            max=Math.max(max,dp[0][j]*dp[0][j]);
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                    max=Math.max(max,dp[i][j]*dp[i][j]);
                }
            }
        }
        return max;
    }
    //dp[i][j] 代表(i,j)为右下角，且只包含1的正方形的边长的最大值。
    public int maximalSquare2(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;   //可以在循环里面对第一行和第一列赋值，应为我们是从上到下，从左到右计算dp[i][j]
                    } else {
                        //转移方程，当前位置的边长只取决于左边一个，上面一个，左上一个位置，取其中最小值
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
    public static void main(String[] args ){

        MaxSqare_221 sr=new MaxSqare_221();
        char[][] a=new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},};

        System.out.println(sr.maximalSquare(a));
    }
}
