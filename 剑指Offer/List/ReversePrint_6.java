public class ReversePrint_6 {
    LinkedList<ListNode> ls=new LinkedList<ListNode>();
    public int[] reversePrint(ListNode head) {
        ReverseRecur(head);
        int len = ls.size();
        int[] rp=new int[len];
        for(int i=0;i<len;i++){
            rp[i]=ls.poll().val;//依次弹出队首元素
        }
        return rp;
    }

    //先走至链表末端，回溯时依次将节点值加入列表。
    //其实用栈的话就是先将元素入栈，在依次弹出栈即可，和递归实质是一样。
    //先遍历到尾结点，再从尾结点开始向前回溯，栈不过是用数据结构保存了递归实现的系统栈。
    public void ReverseRecur(ListNode head){
        //碰到null结点返回
        if (head == null) return;
        //一直往下走
        ReverseRecur(head.next);
        //从最后一个链表结点开始添加元素
        ls.add(head);
    }

    //按输入数组构造一个链表
    public ListNode Create_Listnode(int[] a){
        if(a.length==0)return null;
        ListNode head=new ListNode(a[0]);
        ListNode hd=head;
        for (int i=1;i<a.length;i++){
            hd.next=new ListNode(a[i]);
            hd=hd.next;
        }
        return head;
    }
    public static void main(String[] args)
    {
        ReversePrint_6 sr=new ReversePrint_6();
        int[] a={1,2,3,4,5};
        ListNode ltn=sr.Create_Listnode(a);
        int[] npvar=sr.reversePrint(ltn);
        for(int e:npvar){
            System.out.print(e+"  ");
        }
    }
}
