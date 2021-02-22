public class PostUnrecursion {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {  //如果c有左孩子并且h节点不是c的左右孩子，就将c左孩子压入栈
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {  //如果c有右孩子并且h节点不是c的右孩子，就将c右孩子压入栈，
                    //一种情况是h是c的左孩子
                    stack.push(c.right);
                } else {//如果c为叶子节点则直接弹出，如果c的左右孩子都弹出了则将c弹出
                    System.out.print(stack.pop().value + " ");
                    h = c;  //h记录上一次弹出的节点
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        // unrecursive
        System.out.println("============unrecursive=============");
        posOrderUnRecur2(head);

    }
}
