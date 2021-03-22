public class Count1_43 {
    //将一个数分为高位high、当前位cur、低位low
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        //cur从最低位个位开始
        while(high != 0 || cur != 0) {
            //找规律，分三种情况
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            //cur往高位移动
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
    public static void main(String[] args)
    {
        Count1_43 sr=new Count1_43();
        System.out.println(sr.countDigitOne(2304));
        System.out.println(sr.countDigitOne(1));
    }
}
