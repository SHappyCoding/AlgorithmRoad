public class LargeRectang_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];        //找每个柱子的左边界
        int[] right = new int[n];       //找每个柱子的右边界

        //Stack<Integer> mono_stack = new Stack<Integer>();
        Deque<Integer> mono_stack=new LinkedList<>();  // java推荐用队列实现栈
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
    public int largestRectangleArea2(int[] heights) {
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

    public static void main(String[] args) {
        LargeRectang_84 sr=new LargeRectang_84();
        int[] a={2,1,5,6,2,3};
        System.out.println(sr.largestRectangleArea2(a));
    }
}
