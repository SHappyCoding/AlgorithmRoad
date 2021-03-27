public class MaxValue_47 {

    //dp[i][j] 当前这个格子所有路径中的礼物最大值
    public int maxValue(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int[][] dp=new int[row][col];
        dp[0][0]=grid[0][0];
        //将第一行和第一列的数据dp赋值
        for(int i=1;i<row;i++) dp[i][0] = dp[i-1][0]+grid[i][0];
        for(int j=1;j<col;j++) dp[0][j] = dp[0][j-1]+grid[0][j];
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                //转移方程
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    //原地修改grid节省空间
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                //以上循环每轮都冗余了一次判断
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    //多开一行一列代码更加简洁
    public int maxValue3(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args)
    {
        MaxValue_47 sr=new MaxValue_47();
        int[][] grid=new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };

        System.out.println(sr.maxValue(grid));
    }
}
