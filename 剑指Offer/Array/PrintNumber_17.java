public class PrintNumber_17 {
    public int[] printNumbers(int n) {
        int len=(int)Math.pow(10,n)-1;
        int[] res=new int[len];
        for(int i=0;i<len;i++){
            res[i]=i+1;
        }
        return res;
    }

    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    //考虑大数，此时只能用字符串来表示数
    public String printNumbers2(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1; //开始截取字符串的位置，初始化针对1-9，例如n=3，005此时截断start为=2=n-1，截取之后就是5
        dfs(0);
        res.deleteCharAt(res.length() - 1);//取掉最后多余的标点符号
        return res.toString();
    }
    //递归求解全排列问题，去固定第x位
    void dfs(int x) {
        if(x == n) {  // 终止条件：已固定完所有位
            String s = String.valueOf(num).substring(start); //去除一个数高位的0，当n=4,且10-99时：例如：0055，start为=n-1-1=2，截取之后就是55,第二个一表示9出现的次数
            if(!s.equals("0")) res.append(s + ",");  //去掉0这个数
            if(n - start == nine) start--;  //截取的位置有规律：n=4时：1-9，start=3。10-99，start=2。100-999，start=1。1000-9999，start=0
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++; //9的个数
            num[x] = i;  //每个位置有10个选择
            dfs(x + 1);  //递归固定第x+1个位置
        }
        nine--; //回溯
    }


    public static void main(String[] args) {
        PrintNumber_17 mq = new PrintNumber_17();
        int[] a=mq.printNumbers(2);
        for(int e :a){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.print(mq.printNumbers2(2));


    }
}
