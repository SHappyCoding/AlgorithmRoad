public class MaxQueue_59_2 {
    private LinkedList<Integer> A,B;
    public MaxQueue_59_2() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public int max_value() {
        if(A.isEmpty())return -1;
        return B.peekFirst();
    }

    public void push_back(int value) {
        //B队列尾部依次弹出比value值小的数，使B保持单调递减
        while(!B.isEmpty() && B.peekLast() < value) B.pollLast();
        A.offerLast(value);
        B.offer(value);//都是入队，元素插入队尾
    }

    public int pop_front() {
        if(A.isEmpty())return -1;
        //如果A队首就是栈的最大值，那么需要将B的队首也要弹出
        if(B.peek().equals(A.peek()))B.pollFirst();
        //弹出A的队首
        return A.poll();

    }

    public static void main(String[] args) {
        MaxQueue_59_2 mq = new MaxQueue_59_2();
        mq.push_back(1);
        mq.push_back(2);
        System.out.println(mq.max_value());
        System.out.println(mq.pop_front());
        System.out.println(mq.max_value());

    }
}
