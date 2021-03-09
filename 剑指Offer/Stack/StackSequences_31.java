public class StackSequences_31 {

    //给定一个压入序列pushed 和弹出序列popped ，则压入和弹出操作的顺序，即排列是唯一确定的
    //如果排列正确则最后辅助栈是没元素的，全部弹出去了。
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack=new LinkedList<>();
        int i=0;
        for(int e:pushed){
            //push入栈
            stack.push(e);
            //模拟弹出栈操作，如果当前栈顶和push[i]相等表示要从栈顶弹出元素了，不相等则继续入栈
            while (!stack.isEmpty() && stack.peek()==popped[i]){
                stack.pop();
                //弹出一个元素，就在栈中继续寻找下一个要弹出的元素
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackSequences_31 sr=new StackSequences_31();
        int[] a={1,2,3,4,5};
        int[] b={4,5,3,2,1};
        System.out.println(sr.validateStackSequences(a,b));

    }
}
