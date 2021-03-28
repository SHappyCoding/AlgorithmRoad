public class Permutation_38 {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    //1、明确函数功能，函数用来求所有的解决方案
    void dfs(int x) {
        //2、递归出口，所有字母已经加入字符数组
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {//将第 x 位字符与 i ∈ [x, len(c)] 字符分别交换，并进入下层递归；
            //3、 重复，因此剪枝，不交换
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            //4、明确下一个字符
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            //5、恢复现场
            swap(i, x);
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Permutation_38 sr = new Permutation_38();
        String s="abc";
        String[] sset=sr.permutation(s);
        for(String e:sset){
            System.out.println(e);
        }
    }
}
