public class Arrayroad_12 {

    //数组的行数、列数
    private int m, n;

    public boolean exist(char[][] board, String word) {
        //如果数组为空，或者数组没有数据则返回0
        if (board == null || board.length == 0) {
            return false;
        }
        //得到行数，列数
        m = board.length;
        n = board[0].length;
        char[] words=word.toCharArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfsString(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    //由一个点展开，深度遍历字符串
    public boolean dfsString(char[][] board,char[] word,int i,int j,int k) {
        //如果超过数组边界或者当前值不是指定字符串中的值(剪枝)，返回false，
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] != word[k]) return false;
        //已经查到了最后一个字符都正确，则返回true
        if (k == word.length - 1) return true;
        //遍历过的字符进行重新赋值为'\0'，代表此元素已访问过，防止之后搜索时重复访问。遇到这个元素就相当于剪支
        board[i][j] = '\0';
        //上下左右四个方向进行遍历指定字符，有一条路径正确就返回true
        boolean res = dfsString(board, word, i + 1, j, k + 1) || dfsString(board, word, i - 1, j, k + 1) ||
                dfsString(board, word, i, j + 1, k + 1) || dfsString(board, word, i, j - 1, k + 1);
        //当前字符又变回原来的值，也就是还原矩阵。
        board[i][j] = word[k];
        return res;

    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};
        Arrayroad_12 t=new Arrayroad_12();
        System.out.print(t.exist(board,"abfb")+"\n");
        System.out.print(t.exist(board,"bfce")+"\n");

    }
}
