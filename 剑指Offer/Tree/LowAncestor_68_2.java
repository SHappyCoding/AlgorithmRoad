public class LowAncestor_68_2 {
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口，遇到结点p或q时返回
        if(root == null || root == p || root == q) return root; //遇到结点p或q时返回
        //递归左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        //System.out.print(root.val+"  ");
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //递归右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p,q都不在左子树，则p和q一定都在右子树中，则在右子树中的最近公共祖先(一个节点也可以是它自己的祖先)
        if(left == null) return right;
        if(right == null) return left;
        //q，p在root的异侧则root为最近公共祖先
        return root;
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
        LowAncestor_68_2 sr = new LowAncestor_68_2();
        Integer[] a = {3,5,1,6,2,0,8,null,null,7,4};
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
        System.out.println(sr.lowestCommonAncestor(tn[0],tn[3],tn[10]).val);

    }
}
