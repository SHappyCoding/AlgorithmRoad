/**
*最优子结构：
*	令X={x1,x2,…xm}，Y={y1,y2,…yn}为二个序列，子序列
*	Z＝{z1,z2,…zk}是X和Y的一个最长公共子序列，则：
*	①if xm=yn then zk=xm=yn且Zk-1是Xm-1和Yn-1的LCS
*	②if xm≠yn且zk≠xm  then Z是Xm-1和Y的LCS 
*	③if xm≠yn且zk≠yn  then Z是X和Yn-1的LCS
*
*dp[i+1\][j+1\]表示text1[0，i]和text2[0，j]的最大公共子序列。
*因为这里序列是从0开始的，跟算法导论里面不一样，你就可以直接把dp扩充一格即可。
*/

public class LCS_1143 {
    //动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();
        //dp[i+1][j+1]表示text1[i]和text2[j]的最大公共子序列
        int[][] dp=new int[len1+1][len2+1];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                //状态转移方程
                if(text1.charAt(i)==text2.charAt(j))dp[i+1][j+1]=dp[i][j]+1;
                else dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LCS_1143 sr=new LCS_1143();
        String t1="abcde";
        String t2="ace";
        System.out.print(sr.longestCommonSubsequence(t1,t2));
    }
}
