public class Wordexist_79 {
    public boolean exist(char[][] board, String word) {
        int row=board.length,col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(recur(board,i,j,word,0)){    //每个单词开始匹配，从word的0开始匹配
                    return true;
                }
            }
        }
        return false;
    }
    //k表示word字符的下标，1、匹配从i,j出发是否有匹配word单词
    public boolean recur(char[][] board,int i,int j,String word,int k){
        //2、递归出口，也就是剪枝
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(k))return false;
        //2、递归出口，最后一个单词已经匹配，直接返回true
        if(k==word.length()-1)return true;

        board[i][j]='\0'; //走过的地方设置为'\0'
        //3、明确所有路径：这里路径是往下一行放皇后
        boolean flag=recur(board,i+1,j,word,k+1) || recur(board,i,j+1,word,k+1) || recur(board,i-1,j,word,k+1) || recur(board,i,j-1,word,k+1);
        //4、回溯。恢复现场
        board[i][j]=word.charAt(k);

        return flag;
    }

    public static void main(String[] args) {
        char[][] grid=new char[][]{{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        Wordexist_79 t=new Wordexist_79();
        System.out.print(t.exist(grid,"ABCCED"));

    }
}
