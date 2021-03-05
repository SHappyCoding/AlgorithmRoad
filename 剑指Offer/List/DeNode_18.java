public class DeNode_18 {
    //双指针，pre指向删除的前一个结点，cur指向要删除的结点
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)return head;
        if(head.val==val) return head.next;
        ListNode pre,cur=head;
        while(cur.next!=null){
            pre=cur;
            cur=pre.next;
            if(cur.val==val)pre.next=cur.next;
        }
        return head;
    }

    //单指针
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        //此时pre就是cur，cur.next就是要删除的结点
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
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
        DeNode_18 sr=new DeNode_18();
        int[] a={1,2,3,4,5};
        ListNode ltn=sr.Create_Listnode(a);
        //ltn=sr.deleteNode(ltn,6);
        ltn=sr.deleteNode2(ltn,4);
        while(ltn!=null){
            System.out.print(ltn.val+"  ");
            ltn=ltn.next;
        }
    }
}
