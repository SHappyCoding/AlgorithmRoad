public class RBT_Is {
    //判断黑高
    public static boolean isRBT(RBT_Node root)
    {
        int count = 0;//统计一条路径上黑节点数目
        int num = 0;
        if(!isBST(root)) return false;
        if(root==null) return true;
        else
        {
            if(root.color==Colors.RED) return false;
            RBT_Node current = root;
            while(current!=null)
            {
                if(current.color==Colors.BLACK)
                    count++;
                current = current.left;
            }
//   System.out.println(count);
        }//算了整棵树的黑高，包括叶子结点
        return check(root,num,count);
    }


    private static boolean check(RBT_Node root, int num,int count)
    {
        RBT_Node current = root;
        if(current.parent!=null && current.color==Colors.RED && current.parent.color==Colors.RED)
        {//这里用parent，其实考虑到了判叶子结点，如果当前节点是叶子节点那么这个判断和，判叶子结点是可以同时进行的
            System.out.println("错误：存在连续红色节点");
            return false;
        }
        if(current.color==Colors.BLACK) num++;
        if(current.left==null && current.right==null)//判断当前是不是叶子结点，如果是叶子结点
        {
            if(num==count) return true;//并且当前黑高和标准黑高相等就返回true
            else
            {//到达叶子结点时，黑高和标准黑高不想等就直接返回false
                System.out.println("存在黑高度不一致的路径！");
                return false;
            }
        }
        return check(root.left, num, count) && check(root.right, num, count);
    }

    public static void main(String[] args) {
        RedBlackTree RBT = new RedBlackTree();
        RBT_Node root=RBT.NIL;
        Integer[] a={1,5,6,7,8,9,10,11,12,13,14,15};
        //Integer[] a={41,38,31,12,19,8};
        //Integer[] a={41,38,31,12,19,8,8,41};
        int len = a.length;
        for (int i = 0; i < len; i++) {
            root=RBT.RBT_Insert(root,new RBT_Node(a[i]));
        }
        RBT.InOrder(root);
//        System.out.println("------------------------");
//        RBT.PostOrder(root);
//        System.out.println("------------------------");
//        System.out.println(RBT.IsRBTree(root));
//        RBT_Node temp=RBT.Tree_Search(root,38);
//        System.out.printf("%-8s  %-4d\n",temp.color,temp.key);//左对齐占8个字符输出(默认右对齐)
        root=RBT.RBT_Delete(root,RBT.Tree_Search(root,14));
        root=RBT.RBT_Delete(root,RBT.Tree_Search(root,9));
        root=RBT.RBT_Delete(root,RBT.Tree_Search(root,5));
        System.out.println("------------------------");
        RBT.InOrder(root);
//        System.out.println(RBT.IsRBTree(root));

    }
}
