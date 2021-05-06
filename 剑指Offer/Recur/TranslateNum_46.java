public class TranslateNum_46 {

    int count=0;
    public int translateNum(int num) {
        char[] res=String.valueOf(num).toCharArray();  //将数字变成char数组
        recur(res,0);
        return count;
    }

    //当前数字翻译成字母进行递归
    public void recur(char[] num,int i){
        if(i>=num.length-1){
            count++;
        }else{
            recur(num,i+1);
            int temp=(num[i]-'0')*10+(num[i+1]-'0');
            if(temp>9 && temp<26)recur(num,i+2); //可以尝试连着两个数字转化成一个字母，这个字母值必须要在0-25之内

        }
    }

    //dp[i]表示[0,i)的能翻译成小写字母个数
    public int translateNum3(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] c=s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i + 1] = dp[i]; //当前字母至少有一种翻译方法，dp[i+1]表示[0,i]的能翻译成小写字母个数,当前字母是i
            int temp = (c[i-1] - '0') * 10 + (c[i] - '0');
            if (temp > 9 && temp < 26) dp[i + 1] += dp[i - 1]; //当前字母和前一个字母构成一种翻译方法
        }
        return dp[len];
    }

    //dp[i]
    public int translateNum2(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q; //代替dp[i - 1]
            q = r; //q代替dp[i]
            //r = q; //r代替了dp[i + 1]
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }



    public static void main(String[] args){
        TranslateNum_46 sr=new TranslateNum_46();
        System.out.println(sr.translateNum(12258));
        System.out.println(sr.translateNum2(12258));
        System.out.println(sr.translateNum3(12258));
    }

}
