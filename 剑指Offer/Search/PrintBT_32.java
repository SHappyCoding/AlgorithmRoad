public class PrintBT_32 {
    //层次遍历，自己写的链表基础用得不好，多花了一个LinkedList去存每一层的结点
    public int[] levelOrder(TreeNode root) {
        //树为空，返回一个空列表
        if(root==null)return new int[0];
        List<TreeNode> ls=new LinkedList<TreeNode>(){{add(root);}},tmp;
        List<Integer> cur=new LinkedList<Integer>(){{add(root.val);}};
        while(!ls.isEmpty()){
            tmp=new LinkedList<TreeNode>();
            for(TreeNode node:ls){
                if(node.left!=null){
                    tmp.add(node.left);
                    cur.add(node.left.val);
                }

                if(node.right!=null){
                    tmp.add(node.right);
                    cur.add(node.right.val);
                }
            }
            ls=tmp;
        }
        //可以得到一个Inerger的数组，是cur的副本不是
        //Integer[] el=cur.toArray(new Integer[cur.size()]);
        int[] el=new int[cur.size()];
        for(int i=0;i<cur.size();i++)el[i]= cur.get(i);
        return el;
    }

    public int[] levelOrder2(TreeNode root) {
        if(root == null) return new int[0];
        //生成一个队列
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        //生成一个动态数组，用来添加添加数据
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            //弹出队首元素
            TreeNode node = queue.poll();
            ans.add(node.val);
            //遍历下一层，加入队列
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    //按输入数组构造一棵树
    public void Create_BiTree(TreeNode[] a){
        int len=a.length;
        if(len==0)return;
        for (int i=0;i<len;i++){
            if(2*i+1<len)a[i].left=a[2*i+1];
            if(2*i+2<len)a[i].right=a[2*i+2];
        }
    }
    public static void main(String[] args)
    {
        PrintBT_32  sr=new PrintBT_32();
        Integer[] a={3,9,20,null,null,15,7};
        int len=a.length;
        TreeNode[] tn=new TreeNode[len];
        for (int i=0;i<len;i++){
            if(a[i]==null){
                tn[i]=null;
            }else{
                tn[i]=new TreeNode(a[i]);
            }
        }
        sr.Create_BiTree(tn);//先将数组转换成二叉树
        System.out.println("--------------------------");
        int[] el=sr.levelOrder(tn[0]);
        for(int e:el)System.out.print(e+" ");
        System.out.println();
        int[] elt=sr.levelOrder2(tn[0]);
        for(int e:elt)System.out.print(e+" ");
        System.out.println("\n"+"--------链表变成数组---------");
        List<String> theList = new LinkedList<String>();
        theList.add("A");
        theList.add("B");
        theList.add("C");
        theList.add("D");
        //将LinkedList转换为数组，参数是一个类型即可
        String[] my = theList.toArray(new String[0]);
        for (int i = 0; i < my.length; i++) {
            System.out.print(my[i]+"  ");
        }
        System.out.println();
        String[] my1 = theList.toArray(new String[theList.size()]);
        for (int i = 0; i < my1.length; i++) {
            System.out.print(my1[i]+"  ");
        }
    }
}
