public class SubStructure_26 {
    //1、遍历A每个结点
    //
    //2、判断以当前结点n为根的树是否包含了B子结构

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //1、A为空或者B直接返回false
        //2、判断B是否是A结点为根的二叉树的子结构，继续递归B是否是A左孩子结点为根的二叉树的子结构，和B是否是A右孩子结点为根的二叉树的子结构
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //递归遍历B为根的子结构是否是A结点为根的二叉树的子结构
    public boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;  //B遍历到外面，遍历完了直接返回true
        if(A == null || A.val != B.val) return false;  //B不为空，但是A此时已经为空了，说明B不为A的子结构
        return recur(A.left, B.left) && recur(A.right, B.right);//递归往下遍历
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
        SubStructure_26 sr = new SubStructure_26();
        Integer[] a = {3, 4, 5, 1, 2};
        Integer[] b = {4, 1};
        //Integer[] a={1,2,3,4,null,null,5};
        int len = a.length;
        TreeNode[] tn = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (a[i] == null) {
                tn[i] = null;
            } else {
                tn[i] = new TreeNode(a[i]);
            }
        }
        int len2 = b.length;
        TreeNode[] tn1 = new TreeNode[len2];
        for (int i = 0; i < len2; i++) {
            if (b[i] == null) {
                tn1[i] = null;
            } else {
                tn1[i] = new TreeNode(b[i]);
            }
        }
        sr.Create_BiTree(tn);//先将数组转换成二叉树
        sr.Create_BiTree(tn1);//先将数组转换成二叉树
        System.out.print(sr.isSubStructure(tn[0],tn1[0]));


    }
}
