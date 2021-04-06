public class LastRemain_62 {
    //利用动态数组
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n); //动态数组
        for (int i = 0; i < n; i++) {
            list.add(i);  //向数组中加入n个数
        }
        int idx = 0;
        while (n > 1) { //循环n-1次
            idx = (idx + m - 1) % n;  //当前要删除的坐标
            list.remove(idx);  //这个方法会使原来元素的下标都向前移动一格，所以可以就是(idx+m-1)%n
            n--;
        }
        return list.get(0); //最后就剩下一个数
    }

    //递归的数学推导
    public int lastRemaining3(int n, int m) {
        return f(n, m);
    }
    //函数的返回值为最终留下的元素的序号
    public int f(int n, int m) {
        if (n == 1) {
            return 0; //从0开始向上递归，可以想象函数从0开始返回递归向上
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        LastRemain_62 sr=new LastRemain_62();
        System.out.println(sr.lastRemaining(5,3));

    }
}
