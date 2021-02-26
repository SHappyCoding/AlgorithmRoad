public class StackMergeQueue_9 {
    public static class CQueue {
        //LinkedList双向链表，可以当作栈使用，只要一端进出即可
        LinkedList<Integer> s1;//进栈,LinkedList可以当作栈使用，只要一端进出即可
        LinkedList<Integer> s2;//出栈
        public CQueue() {
            s1=new LinkedList<>();
            s2=new LinkedList<>();
        }

        public void appendTail(int value) {
            s1.add(value);
        }

        public int deleteHead() {
            if(s2.isEmpty()){
                if(s1.isEmpty()){//两个栈都为空则没有元素返回-1
                    return -1;
                }
                //出栈空，进栈非空，将进栈元素从栈顶开始加到出栈中，此时出栈顶就是队列首
                while(!s1.isEmpty())s2.add(s1.pop());
                return s2.pop();
            }
            return  s2.pop();//出栈非空直接输出栈顶元素即可
        }
        public void printall(){
            for(int i:s2){
                System.out.print(i+"\n");
            }
            for(int i:s1){//从队首开始输出，此时相当于栈底开了
                System.out.print(i+"\n");
            }
            System.out.print("------\n");
        }

    }
    public static void main(String[] args) {
        CQueue cq=new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        cq.appendTail(3);
        cq.deleteHead();
        cq.printall();
        cq.appendTail(4);
        cq.appendTail(5);
        cq.printall();

    }
}
