public class PubNode_52 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    //1、set
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tA = headA;
        ListNode tB = headB;
        //先把链表A的结点全部存放到集合set中
        while (tA != null) {
            set.add(tA);
            tA = tA.next;
        }
        //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
        while (tB != null) {
            if (set.contains(tB))
                return tB;
            tB = tB.next;
        }
        //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
        return null;
    }

    //双指针，
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tA = headA;
        ListNode tB = headB;
        int la = len(tA), lb = len(tB);
        //让长链表指针先走，走到和短链表长度相等时开始同步走
        while (la != lb) {
            if (la > lb) {
                //如果链表A长，那么链表A先走
                tA = tA.next;
                la--;
            } else {
                tB = tB.next;
                lb--;
            }
        }
        //然后开始比较，如果他俩不相等就一直往下走，走到公共交点为止
        while (tA != tB) {
            tA = tA.next;
            tB = tB.next;
        }
        return tA;
    }
    private static int len(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    // 两个链表长度分别为L1+C、L2+C， C为公共部分的长度
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode tA = headA;
        ListNode tB = headB;
        while (tA != tB) {//最多走两圈
            // 第一个人走了L1+C步后，回到第二个人起点走L2步；
            tA = tA == null ? headB : tA.next;
            //第2个人走了L2+C步后，回到第一个人起点走L1步
            tB = tB == null ? headA : tB.next;
        }
        //有公共交点每个节点走：L1+L2+C
        //无公共交点每个节点走：L1+L2+2C
        return tA;
    }



    public static void main(String[] args) {
//        ListNode[] la=new ListNode[]{
//                new ListNode(4),
//                new ListNode(1),
//                new ListNode(8),
//                new ListNode(4),
//                new ListNode(5),
//        };
        ListNode a0=new ListNode(0);
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a4=new ListNode(4);
        ListNode a9=new ListNode(9);
        a0.next=a9;
        a9.next=a1;
        a1.next=a2;
        a2.next=a4;

        ListNode a3=new ListNode(3);
        a3.next=a2;

        System.out.print(getIntersectionNode(a0,a3).val+"\n");
        System.out.print(getIntersectionNode2(a0,a3).val+"\n");
        System.out.print(getIntersectionNode3(a0,a3).val+"\n");
    }
}
