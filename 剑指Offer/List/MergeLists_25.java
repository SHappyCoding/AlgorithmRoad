public class MergeLists_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个不带数据的头结点
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {//将小的结点加入dum链
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //将剩下的链表直接加入即可
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    //递归代码
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        if(l1.val<l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;//返回小的那个
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

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
        MergeLists_25 sr=new MergeLists_25();
        int[] a={1,2,4};
        int[] b={1,3,4};
        ListNode t1=sr.Create_Listnode(a);
        ListNode t2=sr.Create_Listnode(b);
        ListNode t3= sr.mergeTwoLists2(t1,t2);
        while(t3!=null){
            System.out.print(t3.val+"  ");
            t3=t3.next;
        }

    }
}
