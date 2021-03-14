public class BuildTree_7 {

    private int[] preorder;
    //定位结点，key是结点值，value是结点在数组中的位置方便用hash快速定位结点，而不用每次都遍历中序数组
    private HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //进行hash映射
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    //用当前结点来构造树，root表示在pre数组的下标，left-right子树在中序遍历的左右边界
    public TreeNode recur(int root, int left, int right) {
        //递归出口
        if(left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        //找到根结点在中序数组中的位置、划分根节点、左子树、右子树
        int i = dic.get(preorder[root]);
        //递归构造左右子树
        node.left = recur(root + 1, left, i - 1);
        //右子树的第一个结点在pre中的：根节点索引 + 左子树长度 + 1
        node.right = recur(root + i - left + 1, i + 1, right);
        // 回溯返回根节点
        return node;
    }

    public static void main(String[] args) {
        int[] pre={3,9,20,15,7};
        int[] ino={9,3,15,20,7};
        BuildTree_7 sr = new BuildTree_7();
        System.out.println(sr.buildTree(pre,ino).val);
        System.out.println(sr.buildTree(pre,ino).left.val);
    }
}
