public class VerticalOrder_314 {
    Map map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root){
        if(root==null)return new ArrayList<>();
        Map<Integer,List<Integer>> mp1=new HashMap<>();  //处理有同样列的结点
        Map<TreeNode,Integer> mp2=new HashMap<>();  //标记每个结点所在的列
        mp2.put(root,0);  //设置根结点的列为0，左边就是-1，右边就是+1
        //层次遍历所有结点
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode node=que.poll();
            int i=mp2.get(node);  //得到当前结点的列值
//            //加入拥有相同列值的列表
//            List<Integer> temp=mp1.getOrDefault(i,new ArrayList<>());  //当Map集合中有这个key时，就使用这个key对应的value值，没有就使用默认值defaultValue
//            temp.add(node.val);
            //java8之后,用lamda表达表达式简化，若key对应的value为空，会将第二个参数的返回值存入并返回，执行了map.put(key，value)操作
            //可以直接加入结点的值，对于同一列来说，用层次遍历先遇到时，坑定先输出(从上到下)
            mp1.computeIfAbsent(i,k->new ArrayList<>()).add(node.val);
            //遍历左右孩子结点
            if(node.left!=null){
                que.add(node.left);
                mp2.put(node.left,i-1);
            }
            if(node.right!=null){
                que.add(node.right);
                mp2.put(node.right,i+1);
            }
        }
//        for(int e:mp1.keySet()){
//            System.out.print(e+",");  //很奇怪for遍历keySet的时候也是有序的，添加的时候不是有序的(这里说的有序是指升序不是插入顺序)
//        }

        return new ArrayList<>(mp1.values());  //只要返回每列的列表即可，这里不知道为啥，values输出的时候是按key的顺序来输出的的

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

    public static void main(String[] args) {
        VerticalOrder_314 sr = new VerticalOrder_314();
        Integer[] a = {3,9,20,null,null,15,7};
        int len = a.length;
        TreeNode[] tn = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (a[i] == null) {
                tn[i] = null;
            } else {
                tn[i] = new TreeNode(a[i]);
            }
        }
        sr.Create_BiTree(tn);//先将数组转换成二叉树
        List<List<Integer>> ar=sr.verticalTraversal(tn[0]);

//        System.out.print("[\n");
//        for(List<Integer> ls:ar){
//            System.out.print("  [");
//            for(int e:ls){
//                System.out.print(e+",");
//            }
//            System.out.print("],\n");
//        }
//        System.out.print("]");

        System.out.print("[\n");
        for(List<Integer> ls:ar){
            System.out.print("  ["+ls.get(0));
            for(int i = 1;i<ls.size();i++){
                System.out.print(","+ls.get(i));
            }
            System.out.print("],\n");
        }
        System.out.print("]");

    }
}
