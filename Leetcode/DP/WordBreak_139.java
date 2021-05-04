public class WordBreak_139 {
  //dp[i]表示s的前i位(不包括第i位)是否可以用wordDict中的单词表示
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j=i+1;j<=length;j++){  //如果dp[i]=true且s[i...j)在字典中，则：dp[j]=true;
                if(dp[i] && wordDict.contains(s.substring(i,j)))dp[j]=true;
            }
        }
        return dp[length];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        return back(s,wordDict);
    }

    //字符串s是否可以被字典中的词表示
    public boolean back(String s, List<String> wordDict){
        if(s==null)return false;
        int len=s.length();
        boolean res=false;
        for(int i=1;i<len;i++){
            if(wordDict.contains(s.substring(0,i)))res=back(s.substring(i),wordDict);
            if(res==true)break;
        }
        return res;
    }



    public static void main(String[] args) {
        WordBreak_139 sr=new WordBreak_139();
        List<String> wd=new ArrayList<>(Arrays.asList("leet", "code"));
        String s="leetcode";
        System.out.println(sr.wordBreak(s,wd));
        System.out.println(sr.wordBreak2(s,wd));

    }


}
