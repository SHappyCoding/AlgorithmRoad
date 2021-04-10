public class Reverse_92_2 {

    public ListNode reverse(ListNode head,int left,int right){
        ListNode pre=new ListNode(); //创建一个空的头结点
        pre.next=head;
        ListNode cur=head,hd=pre;
        right--;
        while(--left!=0){
            cur=cur.next;
            pre=pre.next;
            right--;
        }
        ListNode post;
        while(right--!=0){
            post=cur.next;
            cur.next=post.next;
            post.next=pre.next;
            pre.next=post;
        }

        return hd.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;  //pre先走到第left-1个结点
        }
        ListNode cur = pre.next;  //cur走到第left个结点
        ListNode next;
        for (int i = 0; i < right - left; i++) { //是用头插法来插入，反转right - left次即可
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
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
        Reverse_92_2 sr=new Reverse_92_2();
//        int[] a={1,2,3,4,5};
        int[] a={3,5};
        ListNode ltn=sr.Create_Listnode(a);
        ltn=sr.reverse(ltn,1,2);
        while(ltn!=null){
            System.out.print(ltn.val+"  ");
            ltn=ltn.next;
        }
    }

}
