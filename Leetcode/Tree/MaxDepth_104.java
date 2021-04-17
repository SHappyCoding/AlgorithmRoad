public class MaxDepth_104 {
    //dfs,递归实现
    public int maxDepth(TreeNode root) {    //树高度从0开始
        if(root==null)return 0;
        else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //BFS，队列实现
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();    //每次取一层的数据弹出
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;  //弹出一层，就将树高度+1
        }
        return ans;
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
        MaxDepth_104 sr =new MaxDepth_104();
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
        System.out.println(sr.maxDepth(tn[0]));

    }

}
