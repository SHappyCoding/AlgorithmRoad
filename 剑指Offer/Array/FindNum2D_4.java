public class FindNum2D_4 {

    //用递归，从matrix[0][0]开始找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断的顺序不能变，否则编译出错，｜｜有短路效应
        if(matrix == null || matrix.length==0 || matrix[0].length==0 || target<matrix[0][0])return false;
        return dfsfind(matrix,target,0,0);

    }

    //相当于深度遍历
    public boolean dfsfind(int[][] matrix, int target,int i,int j) {
        //如果当前值下于当前值说明数组里面没有这个值
        if(i>=matrix.length || j>=matrix[0].length || target<matrix[i][j]) return false;
        if(target==matrix[i][j])return true;
        //如果当前值大于当前值，需要往右和往下走
        return dfsfind(matrix,target,i+1,j) || dfsfind(matrix,target,i,j+1);
    }

    //线性查找，从二维数组右上角开始查找
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (num > target) {//如果target小于当前值，就应该往左边走
                j--;
            } else {//如果target大于当前值，就应该往下面走
                i++;
            }
        }
        return false;
    }


    public static void main(String[] args)
    {
        FindNum2D_4 sr=new FindNum2D_4();
        int[][] a=new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},};

        System.out.println(sr.findNumberIn2DArray(a,5));
        System.out.println(sr.findNumberIn2DArray(a,20));
        System.out.println(sr.findNumberIn2DArray2(a,20));
    }
}
