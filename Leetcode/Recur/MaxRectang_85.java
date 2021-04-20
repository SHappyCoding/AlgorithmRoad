public class MaxRectang_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len==0)return 0;
        if(len==1)return heights[0];
        int area=0; //记录最大的矩阵面积
        int[] newheights=new int[len+2];    //加入两个哨兵，首尾值都是0
        for(int i=0;i<len;i++)newheights[i+1]=heights[i];
        //新数组的长度
        len+=2;
        Deque<Integer> stack=new LinkedList<>();  // java推荐用队列实现栈
        stack.addLast(0);   //加入的是坐标
        for(int i=1;i<len;i++){
            while(newheights[stack.peekLast()]>newheights[i]){  //栈顶柱子右边第一个小于它的柱子i
                int h=newheights[stack.removeLast()];   //栈顶柱子高度
                int w=i-stack.peekLast()-1;        //stack.peekLast()相当于左边界，i相当于右边界，两个柱子相等时，出栈第二根柱子的时候计算了正确的area
                area=Math.max(area,w*h);
            }
            stack.addLast(i);
        }
        return area;
    }

    public int maximalRectangle4(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] leftLessMin = new int[cols];  //左边界
        int[] rightLessMin = new int[cols];     //右边界
        Arrays.fill(leftLessMin, -1); //初始化为 -1，也就是最左边
        Arrays.fill(rightLessMin, cols); //初始化为 cols，也就是最右边
        int[] heights = new int[cols];
        for (int row = 0; row < matrix.length; row++) {
            //更新所有高度
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //更新所有leftLessMin
            int boundary = -1; //记录上次出现 0 的位置
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    //和上次出现 0 的位置比较
                    leftLessMin[col] = Math.max(leftLessMin[col], boundary);
                } else {
                    //当前是 0 代表当前高度是 0，所以初始化为 -1，防止对下次循环的影响
                    leftLessMin[col] = -1;
                    //更新 0 的位置
                    boundary = col;
                }
            }
            //右边同理
            boundary = cols;
            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    rightLessMin[col] = Math.min(rightLessMin[col], boundary);
                } else {
                    rightLessMin[col] = cols;
                    boundary = col;
                }
            }

            //更新所有面积
            for (int col = cols - 1; col >= 0; col--) {
                int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                maxArea = Math.max(area, maxArea);
            }

        }
        return maxArea;

    }

    public static void main(String[] args) {
        MaxRectang_85 sr=new MaxRectang_85();
        char[][] a=new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},};
        System.out.println(sr.maximalRectangle(a));
    }
}
