public class BanlanceTree_55_2 {
    //后序遍历+剪枝(从底至顶)
    public boolean isBalanced(TreeNode root) {
        return DFSDepth(root) != -1;
    }
    //相当于你现在就是在树底来看这个进行递归。
    public int DFSDepth(TreeNode root) {
        //后序遍历，左右中
        if (root == null) return 0;
        int left = DFSDepth(root.left);
        //这里就相当于剪枝，如果left为-1就会一直向上返回-1，一直到isBalanced()中去
        if(left == -1) return -1;
        int right = DFSDepth(root.right);
        if(right == -1) return -1;
        //当前结点是平衡树，则向上回溯，那么此时结点高度=当前高度+1，当前结点高度为（左右子树最大高度）
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    
    //先序遍历
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        //判断当前结点是不是平衡，再递归判断左子树右子树是不是平衡
        return Math.abs(DFSDepth2(root.left) - DFSDepth2(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算一个结点的深度，此时重复计算了大量重复结点的深度
    private int DFSDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(DFSDepth2(root.left), DFSDepth2(root.right)) + 1;
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
        BanlanceTree_55_2  sr=new BanlanceTree_55_2();
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
        System.out.println(sr.isBalanced(tn[0]));
        System.out.println(sr.isBalanced2(tn[0]));

    }
}
