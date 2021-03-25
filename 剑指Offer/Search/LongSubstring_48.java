public class LongSubstring_48 {

    //暴力破解
    public int lengthOfLongestSubstring(String s) {
        char[] sc = s.toCharArray();
        int max=0,len=sc.length;
        for(int i=0;i<len;i++){
            Set<Character> set = new HashSet<>();
            for (int j=i;j<len;j++){
                if(set.contains(sc[j])){
                    max=max>j-i?max:j-i;
                    break;
                }
                if(j==len-1)return max>j-i+1?max:j-i+1;
                set.add(sc[j]);
            }
        }
        return max;
    }

    //dp[i] 代表以字符 s[i]为结尾的 “最长不重复子字符串” 的长度。
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i,如果没有该key则返回默认值-1。
            dic.put(s.charAt(j), j); // 更新哈希表，保存的是字符最后出现的下标j
            //dp[j - 1]<j-i表示字符s[i]在子字符串dp[j - 1]区间之外
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    //双指针，i表示不重复子串的开始，j表示开始重复的点
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录，哈希表统计字符s[j] 最后一次出现的索引 。
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    public static void main(String[] args) {
        LongSubstring_48 sr=new LongSubstring_48();
        String s = "abcabcbb";

        System.out.println(sr.lengthOfLongestSubstring(s));
        System.out.println(sr.lengthOfLongestSubstring(" "));
        System.out.println(sr.lengthOfLongestSubstring("dvdf"));
        System.out.println(sr.lengthOfLongestSubstring2("dvdf"));

    }
}
