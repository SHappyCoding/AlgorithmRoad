public class Reverse_24 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode hd1=head,hd2=head.next;
        head=head.next;
        hd1.next = null;
        while(head!=null){
            head=head.next;
            hd2.next=hd1;
            hd1=hd2;
            hd2=head;
        }
        return hd1;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre=head,cur=null,t;
        while(pre!=null){
            t=pre.next;
            //每次让pre的next指向cur，实现一次局部反转
            pre.next=cur;
            //反转完成之后，pre，cur同时往前移动一个位置
            cur=pre;
            pre=t;
        }
        return cur;
    }

    // head指向链表尾，cur指向头，t指向cur的下一个。
    public ListNode reverseList3(ListNode head) {
        if(head==null)return null;
        ListNode cur=head,t=null;
        while(head.next!=null){
            t=head.next.next;
            //每次让head下一个结点next指向cur，实现一次局部反转
            head.next.next = cur;
            //反转完成之后，head.next，cur同时往前移动一个位置
            cur=head.next;
            head.next=t;
        }
        return cur;
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
        Reverse_24 sr=new Reverse_24();
        int[] a={1,2,3,4,5};
        ListNode ltn=sr.Create_Listnode(a);
//        while(ltn!=null){
//            System.out.print(ltn.val+"  ");
//            ltn=ltn.next;
//        }
        ltn=sr.reverseList3(ltn);
        while(ltn!=null){
            System.out.print(ltn.val+"  ");
            ltn=ltn.next;
        }
    }
}
