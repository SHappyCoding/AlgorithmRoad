public class IsVaild_20 {
    public boolean isValid(String s) {
        int len=s.length();
        if(len<=1)return false;
        char c=s.charAt(0),temp;
        Deque<Character> stack=new LinkedList<>();
        if(c=='(' || c=='{' || c=='[')stack.push(c);
        else return false;
        for(int i=1;i<len;i++){
            c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[')stack.push(c);
            else{
                temp=stack.pop();   //leetcode好像这个函数是没有返回值的
                if(temp=='(' && c==')')continue;
                if(temp=='{' && c=='}')continue;
                if(temp=='[' && c==']')continue;
                return false;
            }

        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {//如果是奇数则返回
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsVaild_20 sr=new IsVaild_20();
        String s1= "{[]}";
        String s2="([)]";
        System.out.println(sr.isValid(s1));
        System.out.println(sr.isValid(s2));
        System.out.println(sr.isValid2(s1));
        System.out.println(sr.isValid2(s2));
    }
}
