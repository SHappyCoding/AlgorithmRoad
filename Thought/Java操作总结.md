### 模运算：

```
(a + b) % p = (a % p + b % p) % p （1） 　　
(a - b) % p = (a % p - b % p) % p （2） 　　
(a * b) % p = (a % p * b % p) % p （3） 　　
ab % p = ((a % p)b) % p （4） 　　
```



### 位：

```java
//异或：
A^0=A
A^A=0
//一个二进制位
A^1=~A

与：
//获得A的二进制表示中的最低位的 1 的位置,一个数的负数就等于对这个数取反+1
//假设A=1100得到B=100,是一个二进制形式
B = A & (-A):
//B是一个1后面很多0的二进制数，C返回的就是这个1的位置，Integer.bitCount()返回二进制数的1的个数。
C = Integer.bitCount(B - 1);
//消掉n最右边的1
n &= n - 1;
//消掉n最右边的1，可以代替模运算，假设y=y%x可以写成
y=y & (x-1)
//无符号移位
n=n>>>1
//得到两数的非进位和：
a^b
//得到两数的进位和：
(a&b)<<1 
//求n模m的结果，要求结果使n的各个位置变成：0，1，2...(n-1) 
(n-1)%m  
  
//模操作
(a+b)%c=((a%c)+(b%c))%c
a%c=(a%c)%c
```



### 容器：

#### 集合：

##### 列表：

```java
//将列表转化为对应数组
List<String> res = new LinkedList<>();
res.toArray(new String[res.size()]);
//int[] 可以作为数组对象
List<int[]> res = new ArrayList<>();
res.toArray(new int[res.size()][]);//相当于int[][]
```



##### 堆：

```java
Queue<Integer> A= new PriorityQueue<>(); // 小顶堆，
Queue<Integer> B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆
//添加元素
 A.add(num);
//弹出堆顶元素
A.poll();
```

##### 栈:

```java
//栈
Deque<Integer> stack = new LinkedList<>();
//入栈
stack.push(0);
//出栈
stack.pop();
//返回栈顶
stack.peek();
```



##### 队列：

```java
//双端队列
Deque<Integer> deque = new LinkedList<>();
//返回队列的元素个数
queue.size()
//入队，队尾加入元素
deque.addLast(a);
//返回队首
deque.peekFirst();
//返回队尾
deque.peekLast()
//出队，队首删除元素
deque.removeFirst();
//队尾删除元素
deque.removeLast();

//栈
Deque<Integer> stack = new LinkedList<>();
//入栈
stack.addLast(0);
//出栈
stack.removeLast(0);
//返回栈顶
stack.peekLast();

//第二种用LinkedList实现双端队列
LinkedList<Integer> deque =	new LinkedList<>();
//入队，队尾加入元素
deque.offerLast(value);
deque.offer(value);//都是入队，元素插入队尾
//返回队首
deque.peekFirst();
//返回队尾
deque.peekLast();
//队尾删除元素
deque.pollLast();
//出队，队首删除元素
deque.poll()
```

#### Map:

```java
Map<Character,Integer> ma=new HashMap<Character,Integer>();
//遍历
for(Integer e : map.keySet())
for(Double e : map.values())
for(Map.Entry e: map.entrySet()){
            e.getKey(),e.getValue()
        }
//java8之后,用lamda表达表达式简化，若key对应的value为空，会将第二个参数的返回值存入并返回，执行了map.put(key，value)操作
mp1.computeIfAbsent(i,k->new ArrayList<>()).add(node.val);
//当Map集合中有这个key时，就使用这个key对应的value值，没有就使用默认值defaultValue
mp1.getOrDefault(i,new ArrayList<>());  
```





### 排序：

```java
Arrays.sort(nums); //默认升序
//自定规则数组排序：第二个参数就是比较器
Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

@Override
public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
			//开始是1在2的前面；函数返回正数就把2放在1的前面
		}
}
lambda表达式实现升序排序（Arrays.sort(data, (o1, o2) -> o1 - o2);），
lambda表达式实现降序排序（Arrays.sort(data, (o1, o2) -> o2 - o1);），
另一种写法：
需要导入util包下的Comparator类,
lambda表达式实现升序排序（Arrays.sort(data1, (o1, o2) -> o1.compareTo(o2);）
lambda表达式实现降序排序（Arrays.sort(data2, (o1, o2) -> o2.compareTo(o1));）
```



### String：

```java
StringBuilder res = new StringBuilder("[");
res.deleteCharAt(res.length() - 1); //去掉最后一个字符
res.append("]");
//如果不是想每次都加在字符串尾，可以用String
String result = "";
result = left + result;
//字符串转字符数组
char[] charArray = s.toCharArray();
char[] res=sc.nextLine().toCharArray(); //变成字符数组就不会新建立对象，StringBuffer和StringBudilder在append的时候都会新建数组。
new String(res);
```



### 树：

链接：https://blog.csdn.net/shufac/article/details/26979517

```java
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
//非递归先序遍历
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);	//先加入列表
                stack.push(node);		//入栈
                node = node.left;		//遍历左子树
            }
            node = stack.pop();	//弹出栈顶(已经遍历过)，
            node = node.right;	//去遍历右子树
        }
        return res;
    }

//中序遍历
    public void InOrderPrint(TreeNode root){
        if(root==null) return;
        InOrderPrint(root.left);
     		System.out.print(root.val+"  ");
        InOrderPrint(root.right);
    }

//后序遍历
    public void PostPrint(TreeNode root){
        if(root==null) return;
        InOrderPrint(root.left);
        InOrderPrint(root.right);
     	  System.out.print(root.val+"  ");
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
```



### IO：

```java
Scanner sc = new Scanner(System.in);
long a = sc.nextLong();
int a = sc.nextInt();
//用nextLine（）可以读取一整行，包括了空格，next（）却不能读取空格
//Scanner的next和nextLine()方法，两者都是读字符，前者是读到空格为止；后者是读到回车为止，即读一行
String str = sc.nextLine().toString();
//读取一个数组,
int[] a=new int[len];
for(int i=0;i<len;i++){
    a[i]=sc.nextInt();
}
//读取多行输入
int n=in.nextInt();
in.nextLine(); //吃掉一个回车符
String[] sc=new String[n];
for(int i=0;i<n;i++){
     sc[i]=in.nextLine();
}
//读取每行的数据
int[] t1=new int[3];
int i=0;
while(sc.hasNextInt()){ //判断是否有下一个输入是不是int
      t1[i++] = sc.nextInt();
}
String[] str=sc[i].split(" "); //进行空格分割字符串
System.out.print(str[0]+" "+str[1]+"\n");
```



### 数组：

对一个没有序的数组**没有思路就一定要想到排序**：或者map

```
三数之和：leetcode第15题
两数之和：leetcode第1题
```

对于排序的数组：二分，首尾双指针：

```
两数之和：剑指第57题
```















