
//叶子结点指向同一个节点NIL，根节点的parent的指向NIL
public class RedBlackTree {

    RBT_Node NIL=new RBT_Node(null,Colors.BLACK);

    //判定是否是红黑树，黑高是从根到叶子结点的
    public boolean IsRBTree(RBT_Node root) {
        int BlackNodeNum = 0;
        int curBlackNodeNum = 0;
        RBT_Node cur = root;
        while (cur!=NIL) {
            if (cur.color == Colors.BLACK) {
                BlackNodeNum++;
            }
            cur = cur.left;
        }//计算最左边路径的黑高，这里没有包括叶子结点，也就是黑高减一
        return IsRBTreeHelper(root, BlackNodeNum, curBlackNodeNum);
    }

    //判定递归函数
    public boolean IsRBTreeHelper(RBT_Node root,int BlackNodeNum,int curBlackNodeNum){
        //碰到叶子就返回
        if (root == NIL)
        {
            return true;
        }

        if (root.color == Colors.BLACK)
        {//如果当前节点颜色是黑色，这个路径的黑高加1
            curBlackNodeNum++;
            //如果当前黑高和标准黑高相等时
            if (BlackNodeNum == curBlackNodeNum)
            {
                if (root.left == NIL && root.right == NIL)//如果它的左右孩子都直接是叶子结点就直接返回ture
                {
                    return true;
                }else if(root.left == NIL){//左孩子是叶子结点，右孩子不是
                    return IsRBTreeHelper2(root.right);
                }else if(root.right == NIL){//右孩子是叶子结点，左孩子不是
                    return IsRBTreeHelper2(root.left);
                }else{//左右孩子都不是叶子结点
                    return IsRBTreeHelper2(root.left) && IsRBTreeHelper2(root.right);
                }
            }
        }else{//如果两个连着的节点都是红色直接返回false
            if (root.color == root.left.color || root.color == root.right.color)return false;
        }
        //查看左子树和右子树是否是满足红黑树
        return IsRBTreeHelper(root.left, BlackNodeNum, curBlackNodeNum) && IsRBTreeHelper(root.right, BlackNodeNum, curBlackNodeNum);
    }

    //到达黑高相等时后代节点的判断，一条路径上
    public boolean IsRBTreeHelper2(RBT_Node node){
        if(node.color == Colors.BLACK)return false;//孩子为黑直接返回false
        else{//孩子为红
            if (node.left == NIL && node.right == NIL) {//如果右孩子的子代节点是叶节点，直接返回true，否则返回true
                return true;
            } else {
                return false;
            }
        }
    }

    //查找关键字二叉搜索树,如果存在就返回节点所在的引用
    public RBT_Node Tree_Search(RBT_Node root,Integer key)
    {
        //空树和没找到返回NIL，找到了返回对应节点
        while(root!=NIL && key!=root.key){
            if(key<root.key){
                root=root.left;
            }
            else root=root.right;
        }
        return root;
    }

    //左旋
    public RBT_Node Left_Rotate(RBT_Node root,RBT_Node x){
        RBT_Node y=x.right;
        x.right=y.left;
        //判断y的左孩子是不是叶子结点,用其中节点数值等不等于空判断
        if(y.left!=NIL){
            y.left.parent=x;
        }
        y.parent=x.parent;  //link x's parent to y
        //如果x是根节点
        if(x.parent==NIL)root=y;
        else if(x==x.parent.left){
            x.parent.left=y;//如果x是父节点的左孩子就将y置为左孩子
        }else{
            x.parent.right=y;
        }
        //将x置为y的左孩子(左旋)
        y.left=x;
        x.parent=y;
        return root;
    }

    //右旋，x是一个内部节点
    public RBT_Node Right_Rotate(RBT_Node root,RBT_Node x){
        RBT_Node y=x.left;
        x.left=y.right;
        //判断y的右孩子是不是叶子结点,不是叶子结点就将y的右孩子置为x的左孩子
        if(y.right!=NIL){
            y.right.parent=x;
        }
        y.parent=x.parent;  //link x's parent to y
        //如果x是根节点
        if(x.parent==NIL)root=y;
        else if(x==x.parent.left){
            x.parent.left=y;//如果x是父节点的左孩子就将y置为左孩子
        }else{
            x.parent.right=y;
        }
        //将x置为y的左孩子(左旋)
        y.right=x;
        x.parent=y;

        return root;
    }

    //插入,只会插入不同值的节点
    public RBT_Node RBT_Insert(RBT_Node root,RBT_Node z){
        //如果插入节点值已存在则直接返回root
        if(Tree_Search(root,z.key)!=NIL)return root;
        RBT_Node y=NIL;//记录父节点
        RBT_Node x=root;
        //找到插入的位置
        while (x!=NIL){
            y=x;
            if(z.key< x.key)x=x.left;
            else x=x.right;
        }
        z.parent=y;
        //如果红黑树是空树，直接根节点是z；
        if(y==NIL)root=z;
        else if(z.key<y.key)y.left=z;
        else y.right=z;
        z.left=NIL;
        z.right=NIL;
        z.color=Colors.RED;
        //插入到红色节点，可能违反红黑树性质所以需要修正
        return RBT_Insert_Fixup(root,z);

    }

    //插入修正
    public RBT_Node RBT_Insert_Fixup(RBT_Node root,RBT_Node z){
        //z的父节点为红色时需要修正，z在修正过程中都是指向一个红节点
        if(z.parent!=NIL) {//如果z不是根节点
            while (z.parent.color == Colors.RED) {
                //z的父节点是一个左孩子
                if (z.parent == z.parent.parent.left) {
                    RBT_Node y = z.parent.parent.right;
                    if (y.color == Colors.RED) {//其实第一次在z查到树中去的时候，此时z是叶子结点的父节点，z的父节点和叔节点一定是同色的，
                        //第一种情况，z和z的父亲和z的叔节点y是红节点，此时z的父节点的父节点一定是黑色的
                        z.parent.color = Colors.BLACK;
                        y.color = Colors.BLACK;
                        z.parent.parent.color = Colors.RED;
                        z = z.parent.parent;
                    } else if (z == z.parent.right) {
                        //第二种情况，此时z已经是调整一次之后的内部节点了。z是一个右孩子
                        z = z.parent;
                        root=Left_Rotate(root, z);//以z的父节点进行左旋
                    }else{
                        //第三种情况，z是一个左孩子，且叔节点为黑，把z的父节点染黑，z的父节点的父节点染红右旋即可。以z父节点的父节点为中心右旋
                        z.parent.color = Colors.BLACK;
                        z.parent.parent.color = Colors.RED;
                        root=Right_Rotate(root, z.parent.parent);
                        //第二个情况可以转化为第三种情况，这两种情况就不是独立的了
                    }
                } else {
                    RBT_Node y = z.parent.parent.left;
                    if (y.color == Colors.RED) {
                        z.parent.color = Colors.BLACK;
                        y.color = Colors.BLACK;
                        z.parent.parent.color = Colors.RED;
                        z = z.parent.parent;
                    } else if (z == z.parent.left) {
                        z = z.parent;
                        root=Right_Rotate(root, z);
                    }else{
                        z.parent.color = Colors.BLACK;
                        z.parent.parent.color = Colors.RED;
                        root=Left_Rotate(root, z.parent.parent);
                    }
                }
            }
        }
        //树中只有一个刚插入的节点z，染黑即可；
        root.color=Colors.BLACK;
        return root;
    }

    //删除,z是指向被删节点，y指向实际被删节点，x指向拼接节点(也就是y的右孩子)
    public RBT_Node RBT_Delete(RBT_Node root,RBT_Node z){
        RBT_Node y=z;
        RBT_Node x=null;
        Colors color=y.color;
        if(z.left==NIL){
            x=z.right;
            root=RBT_Transolant(root,z,z.right);
        }else if(z.right==NIL){
            x=z.left;
            root=RBT_Transolant(root,z,z.left);
        }else {
            y=Successor(z.right);
            color=y.color;
            x=y.right;
            if(y.parent==z){
                x.parent=y;
            }else {
                root=RBT_Transolant(root,y,y.right);
                y.right=z.right;
                y.right.parent=y;
            }
            root=RBT_Transolant(root,z,y);
            y.left=z.left;
            y.left.parent=y;
            y.color=z.color;
        }
        if(color==Colors.BLACK)root=RBT_Delete_Fixup(root,x);//如果删除的节点颜色是黑色就会要修复
        return root;
    }

    //删除修复，此时删掉了实际节点y，x拼接节点替换了y，y的黑颜色消失，使这条路径上的黑高减一，红黑树性质改变
    public RBT_Node RBT_Delete_Fixup(RBT_Node root,RBT_Node x){
        RBT_Node w=null;
        while (x!=root && x.color==Colors.BLACK){//如果此时x不是根节点，并且为黑，才需要进行不同情况的修复
            if(x==x.parent.left){
                w=x.parent.right;
                if(w.color==Colors.RED){//情况一会转化为2，3，4
                    //情况一,w为红，那么它的孩子都是黑色的，它的父节点一定是黑(x的父节点也一定是黑)
                    w.color=Colors.BLACK;
                    x.parent.color=Colors.RED;
                    root=Left_Rotate(root,x.parent);
                    w=x.parent.right;
                }
                if(w.left.color==Colors.BLACK && w.right.color==Colors.BLACK){
                    //情况二，w为黑，它的孩子都是黑，此时x的父节点颜色未知
                    w.color=Colors.RED;
                    x=x.parent;
                }else if(w.right.color==Colors.BLACK){
                    //情况三，w为黑，它的右孩子是黑，左孩子为红，此时x的父节点颜色未知
                    w.left.color=Colors.BLACK;
                    w.color=Colors.RED;
                    root=Right_Rotate(root,w);
                    w=x.parent.right;
                }else {
                    //情况四，w为黑，它的右孩子是红,此时x的父节点颜色未知
                    w.color=x.parent.color;
                    x.parent.color=Colors.BLACK;
                    w.right.color=Colors.BLACK;
                    root=Left_Rotate(root,x.parent);
                    x=root;
                }
            }else {
                w=x.parent.left;
                if(w.color==Colors.RED){
                    w.color=Colors.BLACK;
                    x.parent.color=Colors.RED;
                    root=Right_Rotate(root,x.parent);
                    w=x.parent.left;
                }
                if(w.right.color==Colors.BLACK && w.left.color==Colors.BLACK){
                    w.color=Colors.RED;
                    x=x.parent;
                }else if(w.left.color==Colors.BLACK){
                    w.right.color=Colors.BLACK;
                    w.color=Colors.RED;
                    root=Left_Rotate(root,w);
                    w=x.parent.left;
                }else {
                    w.color=x.parent.color;
                    x.parent.color=Colors.BLACK;
                    w.left.color=Colors.BLACK;
                    root=Right_Rotate(root,x.parent);
                    x=root;//x设为根，退出循环
                }
            }
        }
        //如果y是根黑节点，x是红节点时，此时x就是根节点了，需要将x染黑
        //需要修复时y一定是黑色的且没有左孩子，x就是y的右孩子，如果x为红时替换y，此时只需将x的颜色变为黑，x的路径黑高就会加1，保持了红黑树性质
        //如果通过情况一到情况二上，上移使x变黑，此时w路径黑高加1，x的左孩子路径黑高加1
        x.color=Colors.BLACK;
        return root;
    }

    // 获取后继节点，右子树中最左孩子,传的就是右孩子
    public RBT_Node Successor(RBT_Node node)
    {
        while(node.left!=NIL){
            node=node.left;
        }
        return node;
    }

    //子树v代替子树u
    public RBT_Node RBT_Transolant(RBT_Node root,RBT_Node u,RBT_Node v){
        //如果u是树根
        if(u.parent==NIL){
            root=v;
        }else if(u==u.parent.left){//u是一个左孩子
            u.parent.left=v;
        }else u.parent.right=v;
        v.parent=u.parent;
        return root;
    }

    //中序遍历红黑树
    public void InOrder(RBT_Node root){
        if(root!=NIL) {
            InOrder(root.left);
            System.out.printf("%-8s  %-4d\n",root.color,root.key);//左对齐占8个字符输出(默认右对齐)
            InOrder(root.right);
        }
    }

    //先序遍历红黑树
    public void PostOrder(RBT_Node root){
        if(root!=NIL) {
            System.out.printf("%-8s  %-4d\n",root.color,root.key);//左对齐占8个字符输出(默认右对齐)
            PostOrder(root.left);
            PostOrder(root.right);
        }
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
