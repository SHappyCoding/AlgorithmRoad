public class PrintBT_32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //层次遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            //queue就从左往右存每层的元素
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                //对偶数层元素，每个元素加在tmp链表的队尾，最后一个加到就是在队尾
                if(res.size() % 2 == 0) tmp.addLast(node.val);// 偶数层 -> 加在tmp队尾
                //对奇数层元素，每个元素加在tmp链表的队首，最后一个加到就是在队首
                else tmp.addFirst(node.val); // 奇数层 -> 加在tmp队首
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            //最后将列表倒序输出即可，奇数层就倒序输出
            if(res.size() % 2 == 1) Collections.reverse(tmp);
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
        PrintBT_32_3  sr=new PrintBT_32_3();
        //Integer[] a={3,9,20,null,null,15,7};
        Integer[] a={1,2,3,4,5};
        //Integer[] a={1,2,3,4,null,null,5};
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
        List<List<Integer>> els=sr.levelOrder(tn[0]);
        for(List<Integer> e:els) {
            for(int s:e) {
                System.out.print(s+" ");
            }
            System.out.println();
        }

    }
}

