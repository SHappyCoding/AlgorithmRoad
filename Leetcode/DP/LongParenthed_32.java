public class LongParenthed_32 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {  //dp[0]=0;s[i-1]='('时：dp[i]=0;
            if (s.charAt(i) == ')') {   //两种情况
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {   //i - dp[i - 1]-1>=0
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1); //栈底保存最后一个没有被匹配的右括号的下标，初始化为-1
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {   //左括号入栈
                stack.push(i);
            } else {    //右括号判断
                stack.pop();    //弹出栈顶
                if (stack.isEmpty()) {
                    stack.push(i);  //如果栈为空，放入最后一个没有被匹配的右括号的下标在栈底
                } else {
                    maxans = Math.max(maxans, i - stack.peek());    //dp[i]=i - stack.peek()
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {  //从左向右遍历
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {      //因为此时有个右括号不可能匹配左边的括号的，重置两个计时器。
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) { //漏掉一种情况：左括号的数量始终大于右括号的数量，从右向左遍历
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LongParenthed_32 sr=new LongParenthed_32();
        String s1="(()(";
        String s2="(()";
        System.out.println(sr.longestValidParentheses(s1));
        System.out.println(sr.longestValidParentheses(s2));
    }
}
