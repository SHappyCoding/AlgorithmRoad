public class MaxPathSum_124 {
    int maxSum = Integer.MIN_VALUE; //保存全局的路径最大和，设这个为初值，考虑了结点全是负数的情况

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    //计算当前结点的最大贡献值，以当前结点为起始点
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0); //舍弃负值
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，该路径经过了左中右，左边可能为0表示就是没有走左边
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回该节点的最大贡献值，一个结点可以选择左边连接和右边连接作为最大和
        return node.val + Math.max(leftGain, rightGain);
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
        MaxPathSum_124 sr =new MaxPathSum_124();
        Integer[] a = {-10,9,20,null,null,15,7};
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
        System.out.println(sr.maxGain(tn[0]));

    }
}
