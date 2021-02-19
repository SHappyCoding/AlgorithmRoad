
public class BinarySearchTree{

	//判断一棵二叉树是否是二叉搜索树，递归2
	public boolean IsBinarySearchTree(BST_Node root) {
		return helper(root, null, null);
	}
	//递归查询子树是否是二叉搜索树
	public boolean helper(BST_Node node, Integer lower, Integer upper) {//一个子树的值应该在(lower,upeer)开区间
		if (node == null) {
			return true;
		}
		int val = node.data;
		//检查这个节点值是否在(lower,upeer)开区间
		if (lower != null && val <= lower) {
			return false;
		}
		if (upper != null && val >= upper) {
			return false;
		}
		//遍历右子树，右子树中所有值都应该在(val,upeer)开区间中
		if (!helper(node.right, val, upper)) {
			return false;
		}
		//遍历左子树，左子树中所有值都应该在(lower,val)开区间中
		if (!helper(node.left, lower, val)) {
			return false;
		}
		//满足在左右子树数值的中间，并且左右子树都是二叉搜索树，返回true
		return true;
	}

	//查找关键字二叉搜索树,如果存在就返回节点所在的引用
	public BST_Node Tree_Search(BST_Node root,int k)
	{
		//空树和没找到返回null，找到了返回对应节点
		while(root!=null && k!=root.data){
			if(k<root.data){
				root=root.left;
			}
			else root=root.right;
		}
		return root;
	}

	// 递归插入
	public BST_Node Tree_Insert(BST_Node root,int k)
	{
		BST_Node newnode=new BST_Node(k);
		//如果树是空树则将节点直接插入
		if( root == null){
			root=newnode;
			return newnode;
		}
		//如果树中有这个值就直接返回null
		if(Tree_Search(root,k)!=null)return null;
		BST_Node y=null;//保存找到的父节点
		while (root!=null){
			y=root;
			//去插入到正确的叶子结点
			if(newnode.data<root.data)root=root.left;
			else root=root.right;
		}
		//插入到指定位置
		if (newnode.data<y.data) y.left=newnode;
		else y.right=newnode;
		return newnode;
	}

	//删除节点,传来的节点已经是树中的节点了,root是树根节点。
	public void Tree_Delete(BST_Node root, BST_Node node) {
		//左孩子不存在，用右孩子直接代替node
		if (node.left == null) Tree_Repalace(root, node, node.right);
		else if (node.right == null) Tree_Repalace(root, node, node.left);//右孩子不存在，用左孩子直接代替node
		else {//左右孩子都存在，找后继继节点和他替换
			BST_Node y = successor(node);
			BST_Node p = Tree_SearchParent(root, y);
			//如果y直接是z的右孩子
			if (p != node) {
				//先将y右孩子替换y的位置
				Tree_Repalace(root, y, y.right);
				y.right=node.right;
			}
			Tree_Repalace(root, node, y);
			y.left = node.left;
		}
	}

	//两棵树,v子树代替u子树
	public void Tree_Repalace(BST_Node root,BST_Node u,BST_Node v){
		BST_Node p=Tree_SearchParent(root,u);
		//如果u的是树根的话
		if(p==null)root=v;
		else if(u==p.left){//u是左孩子，就把v变成左孩子
			p.left=v;
		}
		else p.right=v;
	}

	//查找节点的父节点，这个节点一定是在树中的
	public BST_Node Tree_SearchParent(BST_Node root,BST_Node node)
	{
		BST_Node y=null;
		while(root!=null && node.data!=root.data){
			y=root;
			if(node.data<root.data){
				root=root.left;
			}
			else root=root.right;
		}
		return y;
	}

	// 获取一个节点的后继节点，右子树中最左孩子,传的就是右孩子
	public BST_Node successor(BST_Node node)
	{
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}

	//按输入数组构造一棵树
	public void Create_BiTree(BST_Node[] a){
		int len=a.length;
		if(len==0)return;
		for (int i=0;i<len;i++){
			if(2*i+1<len)a[i].left=a[2*i+1];
			if(2*i+2<len)a[i].right=a[2*i+2];
		}
	}

	//中序遍历二叉树
	public void InOrder(BST_Node root){
		if(root!=null) {
			InOrder(root.left);
			System.out.printf("%-8s  ",root.data);//左对齐占8个字符输出(默认右对齐)
			InOrder(root.right);
		}
	}

	public static void main(String[] args)
	{
		BinarySearchTree BST=new BinarySearchTree();
		Integer[] a={5,1,4,null,null,3,6};
//		Integer[] a={10,5,15,null,null,6,20};
		//Integer[] a={10,5,15,null,null,11,20};
		for(Integer e: a){
			System.out.print(e+" ");
		}
		int len=a.length;
		BST_Node[] BT=new BST_Node[len];
		for (int i=0;i<len;i++){
			//这里之前出现了一个大错误，就是给每一个数组都直接进行创建new BST_Node(a[i]),如果对一个new BST_Node(null)也会创建一个节点，并且这个节点是有数值的;
			//这个节点的组成就是data=left=right=null，而不是整个引用节点=null！！！导致了递归中的错误int val = node.data;赋值之后进行和数值比较发生了空指针错误！
			if(a[i]==null){
				BT[i]=null;
			}else{
				BT[i]=new BST_Node(a[i]);
			}
		}
		BST_Node root=BT[0];
		BST.Create_BiTree(BT);//先将数组转换成二叉树
		System.out.print("\n"+BST.IsBinarySearchTree(root)+"\n");//判断这个二叉树是否是二叉搜索树
		System.out.println("--------------------------");
		BST.InOrder(BT[0]);
		//System.out.println((BST.Tree_SearchParent(root,BT[2])).data);//测试查找父姐节点

	}

}
