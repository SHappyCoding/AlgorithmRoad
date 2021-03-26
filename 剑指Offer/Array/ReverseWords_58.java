public class ReverseWords_58 {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuffer sb=new StringBuffer();
        int j=s.length()-1,i=j;
        //倒序遍历字符串s，记录单词左右索边界i，j
        while(i>=0){
            while(i>=0 && s.charAt(i)!=' ')i--;
            sb.append(s.substring(i+1,j+1)+" ");
            while(i>=0 && s.charAt(i)==' ')i--;//跳过中间空格
            j=i;// j 指向下个单词的尾字符
        }
        return sb.toString().trim();//删除最后添加的尾部空格
    }

    //利用分割函数，不建议利用太多库函数
    public String reverseWords2(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串，会得到很多空字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格
    }



    public static void main(String[] args)
    {
        ReverseWords_58 sr=new ReverseWords_58();
        String s="the sky is blue";
        String s1="  hello world!  ";
        System.out.println(sr.reverseWords(s));
        System.out.println(sr.reverseWords(s1));

    }
}
