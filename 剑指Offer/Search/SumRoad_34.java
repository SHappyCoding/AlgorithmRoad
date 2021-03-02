public class SumRoad_34 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
    LinkedList<List<Integer>> ls = new LinkedList<>();
    LinkedList<Integer> lsson = new LinkedList<>();


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        DFSpath(root, sum);
        return ls;
    }
    public void DFSpath(TreeNode root, int sum){
        //当前结点为空，找到了叶子的下面了，需要回溯
        if(root == null) return;
        lsson.add(root.val);
        //如果到了叶子结点，目标路径存在则直接复制当前路径列表加入二维列表
        if(sum==root.val && root.left==null && root.right==null){
            ls.add(new LinkedList(lsson));//如果直接加入列表，不是复制，那么ls里面始终只有一个路径，而且一直在变
        }
        DFSpath(root.left, sum- root.val);
        DFSpath(root.right, sum- root.val);
      	//先序遍历完之后就要向上回溯
        lsson.removeLast();//向上回溯时删除当前结点
    }

}
