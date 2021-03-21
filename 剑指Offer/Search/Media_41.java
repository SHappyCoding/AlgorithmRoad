public class Media_41 {
    Queue<Integer> A, B;
    public Media_41() {
        //元素个数N=k+k或者N=k+1+k
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半，(k或k+1个)
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半(k个)
    }

    public void addNum(int num) {
        if(A.size() != B.size()) {//A个数多余B，向A加入一个数，再弹出栈顶加入B，此时A和B元素相等
            A.add(num);
            B.add(A.poll());
        } else {//个数相等时，将元素加入B，然后弹出栈顶加入A，此时A比B多一个元素
            B.add(num);
            A.add(B.poll());
        }
    }
    //
    public double findMedian() {
        //不等时，弹出A栈顶即可，相等弹出两个栈顶平均数
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }


    public static void main(String[] args) {
        Media_41 sr=new Media_41();
        sr.addNum(2);
        System.out.println(sr.findMedian());
        sr.addNum(3);
        System.out.println(sr.findMedian());
        sr.addNum(3);
        System.out.println(sr.findMedian());

    }
}
