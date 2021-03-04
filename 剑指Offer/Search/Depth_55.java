public class Depth_55 {

    //层次便利递归实现
    public int maxDepth(TreeNode root) {
        int depth=DFSDepth(root,0);
        return depth;
    }

    public int DFSDepth(TreeNode root,int depth) {
        if(root == null)return depth;
        return Math.max(DFSDepth(root.left,depth+1),DFSDepth(root.right,depth+1));
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //层次遍历，队列实现
    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp=new LinkedList<>();//每次都要创建新的tmp，如果这里是清除所有元素的话，queue也会改变
            //遍历这层中的node，将下一层node加入tmp
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;//改变的是queue指向了tmp
            res++;
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
        Depth_55  sr=new Depth_55();
        Integer[] a={3,9,20,null,null,15,7};
        int len=a.length;
        Algorithm.剑指Ofeer.Node.TreeNode[] tn=new Algorithm.剑指Ofeer.Node.TreeNode[len];
        for (int i=0;i<len;i++){
            if(a[i]==null){
                tn[i]=null;
            }else{
                tn[i]=new Algorithm.剑指Ofeer.Node.TreeNode(a[i]);
            }
        }
        sr.Create_BiTree(tn);//先将数组转换成二叉树
        System.out.println("--------------------------");
        System.out.println(sr.maxDepth3(tn[0]));

    }
}
