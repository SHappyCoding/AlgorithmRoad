public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        // ListNode hd=new ListNode(0);
        // hd.next=head;
        if(head==null)return false;
        ListNode i=head,j=head.next;
        while(j!=null){
            if(i==j)return true;
            else{
                i=i.next;
                j=j.next;
                if(j==null)break;
                else j=j.next;
            }
        }
        return false;
    }


    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;  //初始化就让快指针在前面
        while (slow != fast) {  //只要不相遇就往前走
            if (fast == null || fast.next == null) {    //能到链表尾说明无环
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;    //相遇了说明有环
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
        HasCycle_141 sr=new HasCycle_141();
        int[] a={3,5};
        ListNode ltn=sr.Create_Listnode(a);
        System.out.print(sr.hasCycle2(ltn));
    }
}
