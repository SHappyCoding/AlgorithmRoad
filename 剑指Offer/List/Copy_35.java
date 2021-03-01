public class Copy_35 {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //记载了是否拷贝了这个节点
    HashMap<Node, Node> visited = new HashMap<Node, Node>();


    public static Node copyRandomList(Node head) {
        if(head==null)return head;
        Map<Node,Node> mp = new HashMap<>();//旧结点和新结点进行对应
        Node hd=new Node(head.val);
        mp.put(head,hd);
        Node cur=hd,origincur=head;
        while(origincur.next!=null){  //先复制整条next链，并且在这过程中建立旧结点和新结点(相同值)进行对应关系
            cur.next=new Node(origincur.next.val);
            origincur=origincur.next;
            cur=cur.next;
            mp.put(origincur,cur);
        }
        cur=hd;
        origincur=head;
        while(origincur!=null){  //根据Map来建立random链
            cur.random=mp.get(origincur.random);
            origincur=origincur.next;
            cur=cur.next;
        }
        return hd;
    }

    //DFS深度遍历
    public Node copyRandomList2(Node head) {
        if(head==null)return head;
        //如果拷贝了当前结点直接返回即可
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        Node node = new Node(head.val);
        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }



}
