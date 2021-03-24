public class Kthmax_54 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    //递归查k，这里关键点是对象维护了一个k和res
    void dfs(TreeNode root) {
        if(root == null || k == 0) return;//找到了结点直接返回，剪枝
        dfs(root.right);
        if(--k == 0) res = root.val;
        dfs(root.left);
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
        Kthmax_54 sr = new Kthmax_54();
        Integer[] a = {5,3,6,2,4,null,null,1};
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
        System.out.println(sr.kthLargest(tn[0],3));

    }
}
