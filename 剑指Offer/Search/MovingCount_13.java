public class MovingCount_13 {

    public int movingCount(int m, int n, int k) {
        int[][] res=new int[m][n];
        return recur(res,0,0,k);
    }

    //递归
    public int recur(int[][] res,int i,int j,int k){
        if(i>=res.length || j>=res[0].length || !InOrOut(i,j,k) || res[i][j]==1)return 0;
        //当前值可进入且第一次进，1表示该位置进去过
        res[i][j]=1;
        //只要向下向右走即可遍历所有值，因为从0，0开始走的，这样走一定是连通的
        return 1+recur(res,i,j+1,k)+recur(res,i+1,j,k);
    }

    //判断坐标是否大于k
    public Boolean InOrOut(int i, int j, int k) {
        int sum=0;
        while(i!=0 || j!=0){
            sum+=i%10+j%10;
            i/=10;
            j/=10;
        }
        return sum>k?false:true;
    }

    //广度遍历
    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];//标记格子是否走过
        queue.offer(new int[]{0, 0});//从0，0点开始
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {//向右，向下走两次，也就是与其连通的两个点
                int tx = dx[i] + x;
                int ty = dy[i] + y;//向右走：x=dx[i] + x=0+x=x，y=dy[i] + y=1+y
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});//这个点能走就走，然后放入队列继续下次的广度遍历
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    //递推
    public int movingCount3(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;//当前格子不能走直接去下一个格子
                }
                // 当前格子能走的情况下，边界判断
                //[i.j]只能从[i-1,j]或者[i，j-1]走过来，有一个1这个就可以为1，因为要和上一个走过的点联通才可以加
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }


    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        MovingCount_13 sr = new MovingCount_13();
        System.out.println(sr.movingCount(2,3,1));
        System.out.println(sr.movingCount2(2,3,1));
        System.out.println(sr.movingCount3(2,3,1));

    }
}
