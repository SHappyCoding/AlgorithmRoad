public class MinStack_30 {
    private LinkedList<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack_30() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.push(x);
        //辅助栈B做降序栈，栈顶是栈A的最小值
        //=x的判断可以将多个相同的最小值加入辅助栈
        if(B.isEmpty() || B.peek()>=x)B.push(x);
    }

    //弹出栈顶
    public void pop() {
        //弹出时弹出了最小值需要将辅助栈弹出栈顶
        if (A.pop().equals(B.peek())) B.pop();
    }

    //返回栈顶
    public int top() {
        return A.peek();
    }

    //得到栈的最小值
    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack_30 minStack = new MinStack_30();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}
