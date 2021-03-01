public class IslandNumber_695 {
    //数组的行数、列数
    private int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        //如果数组为空，或者数组没有数据则返回0
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //得到行数，列数
        m = grid.length;
        n = grid[0].length;
        int maxland=0;
        //遍历每个点
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxland = Math.max(maxland, dfsArea(grid, i, j));
            }
        }
        return maxland;
    }
    //由一个点展开，深度遍历岛屿面积
    public int dfsArea(int[][] grid,int i,int j) {
        //超过边界值，碰到0就直接返回
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)return 0;
        //碰到了1就变成0，下次就不会遍历这个地方了
        grid[i][j] = 0;
        int count=1;//岛屿面积+1
        //遍历上下左右
        count+=dfsArea(grid,i-1,j);
        count+=dfsArea(grid,i+1,j);
        count+=dfsArea(grid,i,j-1);
        count+=dfsArea(grid,i,j+1);
        return count;
    }

    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        IslandNumber_695 t=new IslandNumber_695();
        System.out.print(t.maxAreaOfIsland(grid)+"\n");

    }
}
