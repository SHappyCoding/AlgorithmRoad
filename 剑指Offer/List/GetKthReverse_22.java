public class GetKthReverse_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head, post = head;
//        for(int i = 0; i < k; i++)
//            post = post.next;
        while(post != null) {
            //--k是因为一开始cur就指向了head相当于走了一步
            if(--k<0)cur = cur.next;
            post = post.next;
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
        GetKthReverse_22 sr=new GetKthReverse_22();
        int[] a={1,2,3,4,5};
        ListNode ltn=sr.Create_Listnode(a);
        //ltn=sr.deleteNode(ltn,6);
        ltn=sr.getKthFromEnd(ltn,2);
        System.out.print(ltn.val+"  ");
    }
}
