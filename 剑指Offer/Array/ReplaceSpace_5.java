public class ReplaceSpace_5 {
    //for循环遍历
    public String replaceSpace(String s) {
        char[] c=s.toCharArray();
        int len=c.length;
        StringBuffer sb=new StringBuffer();//其实这个也是一个动态数组
        for(int i=0;i<len;i++){
            if(c[i]==' ')sb.append("%20");
            else sb.append(c[i]);
        }
        return sb.toString();

    }

    public String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())//这个遍历方法都不用算长度。。。
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }


    //这种方法最好，利用静态数组，空间可能会浪费
    public String replaceSpace3(String s) {
        int length = s.length();
        char[] array = new char[length * 3];//字符串最多扩充到3倍
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }



    public static void main(String[] args)
    {
        ReplaceSpace_5 sr=new ReplaceSpace_5();
        String s = "We are happy.";
        System.out.println(sr.replaceSpace(s));
        System.out.println(sr.replaceSpace2(s));
        System.out.println(sr.replaceSpace3(s));


    }
}
