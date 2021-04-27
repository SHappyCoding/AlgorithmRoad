package Algorithm.Leetcode.DP;

public class CountSqare_1277 {
    //dp[i][j] 代表(i,j)为右下角，包含的正方形的个数。
    public int countSquares(int[][] matrix) {
        if(matrix==null || matrix.length==0)return 0;
        int row=matrix.length,col=matrix[0].length,count=0;
        int[][] dp=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || j==0){
                    dp[i][j]=matrix[i][j];
                }else if(matrix[i][j]==1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                count+=dp[i][j];
                //System.out.println("dp["+i+"]["+j+"]:="+dp[i][j]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSqare_1277 sr=new CountSqare_1277();
        int[][] a=new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1},};

        System.out.println(sr.countSquares(a));
    }
}
