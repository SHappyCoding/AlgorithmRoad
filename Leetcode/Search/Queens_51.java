public class Queens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        //皇后数组填满-1。queen[i]代表第i行的皇后放在哪一列
        Arrays.fill(queens, -1);
        //列
        Set<Integer> columns = new HashSet<Integer>();
        //主对角线
        Set<Integer> diagonals1 = new HashSet<Integer>();
        //副对角线
        Set<Integer> diagonals2 = new HashSet<Integer>();
        //开始填一个皇后应该填在第-行的哪一列
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        //出口
        if (row == n) {//最后一个皇后放完了，产生一个棋盘
            List<String> board = generateBoard(queens, n);
            //将棋盘加入解决方案
            solutions.add(board);
        } else {//还没出去继续填
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {//如果列冲突了，这个皇后不能放在这一列
                    continue;
                }
                int diagonal1 = row - i;//计算主对角线差值
                if (diagonals1.contains(diagonal1)) {//如果主对角线冲突了，这个皇后不能放这里
                    continue;
                }
                int diagonal2 = row + i;//计算副对角线和
                if (diagonals2.contains(diagonal2)) {//如果副对角线冲突了，这个皇后不能放在这里
                    continue;
                }
                //不冲突就添加当前皇后信息
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                //添加完之后，继续添加下一个皇后，去创造棋盘
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                //向上回溯到这个函数的时候就需要把当前的皇后信息去除
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');//先把这一行填满.
            row[queens[i]] = 'Q';//填q，皇后放在queens[i]列
            board.add(new String(row));//将字符数组转成字符串，添加到board
        }
        return board;
    }

    //基于位运算存储冲突
    public List<List<String>> solveNQueens2(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        //三个冲突分别用一个int表示即可，因为1 <= n <= 9，一个int有32位
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            //(columns | diagonals1 | diagonals2)结果位1表示不可以放皇后的位置，取反1表示可以放皇后的位置
            //得到可以放置皇后的位置：11111111(n个1) & ~(columns | diagonals1 | diagonals2) 最后结果位1就是能放皇后的位置
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {//availablePositions==0表示所有列都不能放皇后，那只能退出回溯了，剪枝
                //获得x的二进制表示中的最低位的 1 的位置，也就是从能放皇后的最小列开始放这一行的皇后，假设availablePositions=1100得到postion=100，是一个二进制形式
                int position = availablePositions & (-availablePositions);
                //可以将 x 的二进制表示中的最低位的 1 置成 0，也就表示这一列放了皇后，下一行个皇后不能放在这一列了，得到放完这个皇后之后，得到下个皇后能放的列
                availablePositions = availablePositions & (availablePositions - 1);
                //计算position-1这个int值二进制形式1的个数：例如：5(101)返回2，表示5的二进制形式有两个1
                //这里就是计算真正的放的皇后的列位置 例如：position=100，函数返回2，表示这是在第二列添加了皇后，position一定是一个1后面很多0的形式
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                //添加完之后，继续添加下一个皇后，去创造棋盘
                //三个冲突要更新，columns要添加当前皇后的列
                //diagonals1主对角线更新，假设当前皇后添加到了第2列，此时就是100，向左移动，表示1000，表示下一行主对角线第3列不能加皇后，如果本来就不能添加到第一列(10),那么下一行也不能添加到第二列（100）：所以要个括号
                //diagonals2负对角线更新，假设当前皇后添加到了第2列，此时就是100，向右移动，表示10，表示下一行负对角线第1列不能加皇后
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                //向上回溯到这个函数的时候就需要把当前的皇后信息去除
                queens[row] = -1;
            }
        }
    }

    //根据皇后数组，生成解决方案
    public List<String> generateBoard2(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


}
