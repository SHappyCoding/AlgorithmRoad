public class PrintBT_32_2 {
    //层次遍历，我多用了一个链表来保存数据
    public List<List<Integer>> levelOrder(TreeNode root) {
        //树为空，返回一个空列表
        if(root==null)return new LinkedList<List<Integer>>();
        LinkedList<List<Integer>> lls = new LinkedList<>();
        List<TreeNode> ls=new LinkedList<TreeNode>(){{add(root);}},tmp;
        List<Integer> cur=new LinkedList<Integer>(){{add(root.val);}};
        while(!ls.isEmpty()){
            lls.add(cur);
            cur=new LinkedList<Integer>();
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
        return lls;
    }

    ////for(int i = queue.size(); i > 0; i--)写的很巧妙
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //队列来保存某一层的元素
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            //弹出某一层的元素
            for(int i = queue.size(); i > 0; i--) {
                //弹出队首元素，
                TreeNode node = queue.poll();
                tmp.add(node.val);
                //加入下一层的元素进队列
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
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
        PrintBT_32_2  sr=new PrintBT_32_2();
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
        List<List<Integer>> el=sr.levelOrder(tn[0]);
        for(List<Integer> e:el) {
            for(int s:e) {
                System.out.print(s+" ");
            }
            System.out.println();
        }

        List<List<Integer>> els=sr.levelOrder2(tn[0]);
        for(List<Integer> e:els) {
            for(int s:e) {
                System.out.print(s+" ");
            }
            System.out.println();
        }


    }
}
