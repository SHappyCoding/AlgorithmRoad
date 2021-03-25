public class FirstChar_50 {


    //统计个数
    public char firstUniqChar(String s) {
        int len=s.length();
        if(len==0)return ' ';
        Map<Character,Integer> ma=new HashMap<Character,Integer>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(ma.containsKey(c)) {
                ma.put(c, ma.get(c) + 1);
                continue;
            }
            ma.put(c,1);
        }

        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(ma.get(c)==1) {
                return c;
            }
        }
        //HashMap遍历是无序的，跟扩容有关系
//        for (Map.Entry<Character, Integer> entry : ma.entrySet())
//        {
//            if(entry.getValue()==1)return entry.getKey();
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }


        return ' ';
    }

    public char firstUniqChar2(String s) {
        //有序Hash表，默认是按插入顺序
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        //s字符串肯定比较长，map遍历长度就可以减少了
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    //出现一次就是true，出现1次以上就是false
    public char firstUniqChar3(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }





    public static void main(String[] args) {
        FirstChar_50 sr=new FirstChar_50();
        String s = "abaccdeff";

        System.out.println(sr.firstUniqChar(s));
        System.out.println(sr.firstUniqChar2(s));
        System.out.println(sr.firstUniqChar3(s));

    }
}

