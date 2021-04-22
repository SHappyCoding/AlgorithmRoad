public class LongPalidrome_5 {
    //DP
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1; //记录子串最大值
        int begin = 0;  //记录最大值的起始位置
        // dp[i][j] 表示 s[i..j] 是否是回文串(包括j)
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度L
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { //如果子串长度是2，因为i+1>j-1
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //中心扩展
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //两个边界情况子串长度为 1 或 2，然后向外扩展，此时扩展中心是i
            int len2 = expandAroundCenter(s, i, i + 1); //i+1=len的时候，expandAroundCenter()函数返回的就是0
            int len = Math.max(len1, len2); //取最大值
            if (len > end - start) {    //新的len值大于原来的回文串长度，这样写会让最大回文串是比较大的扩展中心
                start = i - (len - 1) / 2;  //根据扩展中心和len找到起始坐标
                end = i + len / 2;  //根据扩展中心和len找到结束坐标
            }
        }
        return s.substring(start, end + 1);
    }

    //从left，right开始向外扩展
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {  //一直扩展到子串都不是回文串时
            --left;
            ++right;
        }
        return right - left - 1;    //回文串：s[left+1,right-1]
    }

    public static void main(String[] args) {
        LongPalidrome_5 m4=new LongPalidrome_5();
        String s1="babad";
        System.out.println(m4.longestPalindrome(s1));
    }
}
