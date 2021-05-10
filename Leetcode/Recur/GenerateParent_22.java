ppublic class GenerateParent_22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);//左右括号个数都初始为n个
        return res;
    }
    //str：之前产生的括号，left表示左括号的个数，right表示右括号的个数
    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){ //只能出现left小于right的例子
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }

    //一个括号序列是否有效
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {  //左括号个数小于右括号个数则不是有效的
                return false;
            }
        }
        return balance == 0;    //整个序列遍历完毕之后是否左右括号个数相等
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    //回溯，open代表左括号个数，close代表右括号个数，max单侧代表括号总个数
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {  //如果序列长度是2n表示可以加入
            ans.add(cur.toString());
            return;
        }
        //如果左括号个数小于n，则可以放一个左括号
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            //回溯，删掉添加的符号，保证下个if的时候cur不变
            cur.deleteCharAt(cur.length() - 1);
        }
        //如果右括号个数小于左括号个数，则可以放一个右括号，保证了左括号个数一定是先到n的
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParent_22 sr =new GenerateParent_22();
        List<String> res=sr.generateParenthesis(3);
        for(String e:res){
            System.out.println(e);
        }
    }
}
