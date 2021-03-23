public class MirrorTree_27 {

    //递归
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Swapson(root);
        return root;
    }
    //自己写的递归自顶向下，比较能理解
    public void Swapson(TreeNode root) {
        if(root == null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Swapson(root.left);
        Swapson(root.right);
    }

    //官方递归自底向上，这个还是强
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
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
    //先序遍历
    public void PrePrint(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+"  ");
        PrePrint(root.left);
        PrePrint(root.right);
    }

    //层次遍历
    public void LeverPrint(TreeNode root){
        if(root==null) return;
        Deque<TreeNode> qu=new LinkedList<TreeNode>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode temp=qu.poll();
            System.out.print(temp.val+"  ");
            if(temp.left!=null)qu.add(temp.left);
            if(temp.right!=null)qu.add(temp.right);
        }
    }

    public static void main(String[] args) {
        MirrorTree_27 sr = new MirrorTree_27();
        Integer[] a = {4, 2, 7, 1, 3,6,9};
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
        sr.mirrorTree(tn[0]);
        sr.LeverPrint(tn[0]);

    }
}
